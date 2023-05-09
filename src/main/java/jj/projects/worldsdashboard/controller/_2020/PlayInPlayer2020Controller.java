package jj.projects.worldsdashboard.controller._2020;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.PlayInPlayer2020;
import jj.projects.worldsdashboard.repository._2020.PlayInPlayerRepository2020;


@RestController
@CrossOrigin
public class PlayInPlayer2020Controller {
    private PlayInPlayerRepository2020 playInPlayerRepository2020;

    public PlayInPlayer2020Controller(PlayInPlayerRepository2020 playInPlayerRepository){
        this.playInPlayerRepository2020 = playInPlayerRepository;
    }

    @GetMapping(value="/playInPlayer/2020/{player}")
    public PlayInPlayer2020 getPlayInPlayer2020(@PathVariable String player) {
        return this.playInPlayerRepository2020.findByPlayer(player);
    }
    
}
