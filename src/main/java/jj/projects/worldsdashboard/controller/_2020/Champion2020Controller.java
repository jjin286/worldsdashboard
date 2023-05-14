package jj.projects.worldsdashboard.controller._2020;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.Champion2020;
import jj.projects.worldsdashboard.repository._2020.ChampionRepository2020;

@RestController
@CrossOrigin(origins = { "*" })
public class Champion2020Controller {

    private ChampionRepository2020 championRepository;

    public Champion2020Controller(ChampionRepository2020 championRepository) {
        this.championRepository = championRepository;
    }

    @GetMapping("/2020/champion")
    public List<Champion2020> getAllChampion2020() {
        return this.championRepository.findAll();
    }

    @GetMapping("/2020/champion/{champion}")
    public Champion2020 getChampion2020(@PathVariable String champion) {
        return this.championRepository.findByChampion(champion);
    }

}
