package jj.projects.worldsdashboard.controller._2021;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.PlayInPlayer2021;
import jj.projects.worldsdashboard.repository._2021.PlayInPlayerRepository2021;


@RestController
@CrossOrigin
public class PlayInPlayer2021Controller {
    private PlayInPlayerRepository2021 playInPlayerRepository2021;

    public PlayInPlayer2021Controller(PlayInPlayerRepository2021 playInPlayerRepository){
        this.playInPlayerRepository2021 = playInPlayerRepository;
    }

    @GetMapping(value="/playInPlayer/2021/{player}")
    public PlayInPlayer2021 getPlayInPlayer2021(@PathVariable String player) {
        return this.playInPlayerRepository2021.findByPlayer(player);
    }
    
}
