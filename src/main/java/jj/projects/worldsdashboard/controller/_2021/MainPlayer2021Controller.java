package jj.projects.worldsdashboard.controller._2021;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.MainPlayer2021;
import jj.projects.worldsdashboard.repository._2021.MainPlayerRepository2021;

@RestController
@CrossOrigin
public class MainPlayer2021Controller {
    private MainPlayerRepository2021 mainPlayerRepository2021;

    public MainPlayer2021Controller(MainPlayerRepository2021 mainPlayerRepository){
        this.mainPlayerRepository2021 = mainPlayerRepository;
    }

    @GetMapping("/mainPlayer/2021/{mainplayer}")
    public MainPlayer2021 getMainPlayer2021(@PathVariable String mainplayer) {
        return this.mainPlayerRepository2021.findByPlayer(mainplayer);
    }
}
