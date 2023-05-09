package jj.projects.worldsdashboard.controller;

import jj.projects.worldsdashboard.model._2022.Champion2022;
import jj.projects.worldsdashboard.repository._2022.ChampionRepository2022;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Champion2022Controller {

    private ChampionRepository2022 championRepository;

    public Champion2022Controller(ChampionRepository2022 championRepository) {
        this.championRepository = championRepository;
    }

    @GetMapping("/champion/2022/{champion}")
    public Champion2022 getChampion(@PathVariable String champion) {
        return this.championRepository.findByChampion(champion);
    }


}
