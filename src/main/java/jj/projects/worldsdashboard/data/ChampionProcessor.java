package jj.projects.worldsdashboard.data;

import jj.projects.worldsdashboard.model.Champion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ChampionProcessor implements ItemProcessor<ChampionInput, Champion> {

    private static final Logger log = LoggerFactory.getLogger(ChampionProcessor.class);

    @Override
    public Champion process(final ChampionInput championInput) throws Exception {
        Champion champion = new Champion();
        champion.setId(championInput.getId());
        champion.setChampion(championInput.getChampion());
        champion.setSumTotal(championInput.getSum_total());
        champion.setWinTotal(championInput.getWin_total());
        champion.setLoseTotal(championInput.getLose_total());
        champion.setWinrateTotal(championInput.getWinrate_total());
        champion.setPickRate(championInput.getPick_rate());
        champion.setSumBlueSide(championInput.getSum_blue_side());
        champion.setWinBlueSide(championInput.getWin_blue_side());
        champion.setLoseBlueSide(championInput.getLose_blue_side());
        champion.setWinrateBlueSide(championInput.getWinrate_blue_side());
        champion.setSumRedSide(championInput.getSum_red_side());
        champion.setWinRedSide(championInput.getWin_red_side());
        champion.setLoseRedSide(championInput.getLose_red_side());
        champion.setWinrateRedSide(championInput.getWinrate_red_side());
        champion.setSumBans(championInput.getSum_bans());
        champion.setBanRate(championInput.getBan_rate());
        champion.setSumPickBan(championInput.getSum_pick_ban());
        champion.setPickBanRate(championInput.getPick_ban_rate());
        log.info("Converting (" + championInput + ") into (" + champion + ")");
        return champion;
    }

}