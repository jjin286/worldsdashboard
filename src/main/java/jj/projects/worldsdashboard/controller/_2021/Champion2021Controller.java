package jj.projects.worldsdashboard.controller._2021;

import jj.projects.worldsdashboard.model._2021.Champion2021;
import jj.projects.worldsdashboard.repository._2021.ChampionRepository2021;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Champion2021Controller {

    private ChampionRepository2021 championRepository;

    public Champion2021Controller(ChampionRepository2021 championRepository) {
        this.championRepository = championRepository;
    }

    @GetMapping("/champion/2021/{champion}")
    public Champion2021 getChampion(@PathVariable String champion) {
        return this.championRepository.findByChampion(champion);
    }


}
