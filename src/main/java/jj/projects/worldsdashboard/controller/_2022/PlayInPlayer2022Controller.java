package jj.projects.worldsdashboard.controller._2022;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.PlayInPlayer2022;
import jj.projects.worldsdashboard.repository._2022.PlayInPlayerRepository2022;


@RestController
@CrossOrigin
public class PlayInPlayer2022Controller {
    private PlayInPlayerRepository2022 playInPlayerRepository2022;

    public PlayInPlayer2022Controller(PlayInPlayerRepository2022 playInPlayerRepository){
        this.playInPlayerRepository2022 = playInPlayerRepository;
    }

    @GetMapping(value="/playInPlayer/2022/{player}")
    public PlayInPlayer2022 getPlayInPlayer2022(@PathVariable String player) {
        return this.playInPlayerRepository2022.findByPlayer(player);
    }
    
}
