package jj.projects.worldsdashboard.controller._2022;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.PlayInPlayer2022;
import jj.projects.worldsdashboard.repository._2022.PlayInPlayerRepository2022;


@RestController
@CrossOrigin(origins = { "*" })
public class PlayInPlayer2022Controller {
    private PlayInPlayerRepository2022 playInPlayerRepository;

    public PlayInPlayer2022Controller(PlayInPlayerRepository2022 playInPlayerRepository){
        this.playInPlayerRepository = playInPlayerRepository;
    }

    @GetMapping("/2022/playInPlayer")
    public List<PlayInPlayer2022> getAllPlayInPlayer2022() {
        return this.playInPlayerRepository.findAll();
    }

    @GetMapping(value="/2022/playInPlayer/{player}")
    public PlayInPlayer2022 getPlayInPlayer2022(@PathVariable String player) {
        return this.playInPlayerRepository.findByPlayer(player);
    }
    
}
