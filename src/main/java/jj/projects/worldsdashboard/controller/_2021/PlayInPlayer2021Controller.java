package jj.projects.worldsdashboard.controller._2021;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.PlayInPlayer2021;
import jj.projects.worldsdashboard.repository._2021.PlayInPlayerRepository2021;


@RestController
@CrossOrigin(origins = { "*" })
public class PlayInPlayer2021Controller {
    private PlayInPlayerRepository2021 playInPlayerRepository;

    public PlayInPlayer2021Controller(PlayInPlayerRepository2021 playInPlayerRepository){
        this.playInPlayerRepository = playInPlayerRepository;
    }
    
    @GetMapping("/2021/playInPlayer")
    public List<PlayInPlayer2021> getAllPlayInPlayer2021() {
        return this.playInPlayerRepository.findAll();
    }

    @GetMapping(value="/2021/playInPlayer/{player}")
    public PlayInPlayer2021 getPlayInPlayer2021(@PathVariable String player) {
        return this.playInPlayerRepository.findByPlayer(player);
    }
    
    @GetMapping(value="/2021/playInPlayer/findByTeam/{team}")
    public List<PlayInPlayer2021> getPlayersByTeam(@PathVariable String team) {
        return this.playInPlayerRepository.findByTeam(team);
    }
}
