package jj.projects.worldsdashboard.data;

import jj.projects.worldsdashboard.model.Champion;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {
    @Bean
    public FlatFileItemReader<ChampionInput> reader() {
        return new FlatFileItemReaderBuilder<ChampionInput>()
                .name("championReader")
                .resource(new ClassPathResource("wc_champions.csv"))
                .delimited()
                .names(new String[]{"id","champion","sum_total","win_total","lose_total","winrate_total","pick_rate","sum_blue_side","win_blue_side","lose_blue_side","winrate_blue_side","sum_red_side","win_red_side","lose_red_side","winrate_red_side","sum_bans","ban_rate","sum_pick_ban","pick_ban_rate"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ChampionInput>() {{
                    setTargetType(ChampionInput.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public ChampionProcessor processor() {
        return new ChampionProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Champion> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Champion>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO champion ( id,champion,sum_total,win_total,lose_total,winrate_total,pick_rate,sum_blue_side,win_blue_side,lose_blue_side,winrate_blue_side,sum_red_side,win_red_side,lose_red_side,winrate_red_side,sum_bans,ban_rate,sum_pick_ban,pick_ban_rate) VALUES (:id,:champion,:sumTotal,:winTotal,:loseTotal,:winrateTotal,:pickRate,:sumBlueSide,:winBlueSide,:loseBlueSide,:winrateBlueSide,:sumRedSide,:winRedSide,:loseRedSide,:winrateRedSide,:sumBans,:banRate,:sumPickBan,:pickBanRate)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Champion> writer) {
        return new StepBuilder("step1", jobRepository)
                .<ChampionInput, Champion> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
