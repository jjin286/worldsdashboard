package jj.projects.worldsdashboard.data;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.batch.core.BatchStatus;
        import org.springframework.batch.core.JobExecution;
        import org.springframework.batch.core.JobExecutionListener;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            //Check for 2020 Champions
            jdbcTemplate.query("SELECT champion, sum_total FROM champion2020",
                    (rs, row) -> "Champion2020: " + rs.getString(1) + " Total: " + rs.getString(2)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));

            //Check for 2021 Champions
            jdbcTemplate.query("SELECT champion, sum_total FROM champion2021",
                    (rs, row) -> "Champion2021: " + rs.getString(1) + " Total: " + rs.getString(2)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));

            //Check for 2022 Champions
            jdbcTemplate.query("SELECT champion, sum_total FROM champion2022",
                    (rs, row) -> "Champion2022: " + rs.getString(1) + " Total: " + rs.getString(2)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));
            //Check for 2021 Main Players
            jdbcTemplate.query("SELECT player FROM main_player2021",
                    (rs, row) -> "Main Player: " + rs.getString(1)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));
            //Check for 2021 Play In Players
            jdbcTemplate.query("SELECT player FROM play_in_player2021",
                    (rs, row) -> "Play In Player: " + rs.getString(1)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));
            //Check for 2021 Main Team
            jdbcTemplate.query("SELECT team FROM main_team2021",
                    (rs, row) -> "Main Team: " + rs.getString(1)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));
            //Check for 2021 Play In Team
            jdbcTemplate.query("SELECT team FROM play_in_team2021",
                    (rs, row) -> "Play In Team: " + rs.getString(1)
            ).forEach(str -> log.info("Found <{{}}> in the database.", str));
        }
    }
}
