package jj.projects.worldsdashboard.controller._2020;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.PlayInPlayer2020;
import jj.projects.worldsdashboard.repository._2020.PlayInPlayerRepository2020;


@RestController
@CrossOrigin(origins = { "*" })
public class PlayInPlayer2020Controller {
    private PlayInPlayerRepository2020 playInPlayerRepository;

    public PlayInPlayer2020Controller(PlayInPlayerRepository2020 playInPlayerRepository){
        this.playInPlayerRepository = playInPlayerRepository;
    }

    @GetMapping("/2020/playInPlayer")
    public List<PlayInPlayer2020> getAllPlayInPlayer2020() {
        return this.playInPlayerRepository.findAll();
    }

    @GetMapping(value="/2020/playInPlayer/{player}")
    public PlayInPlayer2020 getPlayInPlayer2020(@PathVariable String player) {
        return this.playInPlayerRepository.findByPlayer(player);
    }
    
    @GetMapping(value="/2020/playInPlayer/findByTeam/{team}")
    public List<PlayInPlayer2020> getPlayersByTeam(@PathVariable String team) {
        return this.playInPlayerRepository.findByTeam(team);
    }
}
