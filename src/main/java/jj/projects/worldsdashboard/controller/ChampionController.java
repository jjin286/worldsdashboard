package jj.projects.worldsdashboard.controller;

import jj.projects.worldsdashboard.model.Champion;
import jj.projects.worldsdashboard.repository.ChampionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChampionController {

    private ChampionRepository championRepository;

    public ChampionController(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    @GetMapping("/champion/{champion}")
    public Champion getChampion(@PathVariable String champion) {
        return this.championRepository.findByChampion(champion);
    }


}
