package jj.projects.worldsdashboard.controller._2020;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.MainPlayer2020;
import jj.projects.worldsdashboard.repository._2020.MainPlayerRepository2020;

@RestController
@CrossOrigin
public class MainPlayer2020Controller {
    private MainPlayerRepository2020 mainPlayerRepository2020;

    public MainPlayer2020Controller(MainPlayerRepository2020 mainPlayerRepository2020){
        this.mainPlayerRepository2020 = mainPlayerRepository2020;
    }

    @GetMapping("/mainPlayer/2020/{mainplayer}")
    public MainPlayer2020 getMainPlayer2020(@PathVariable String mainplayer) {
        return this.mainPlayerRepository2020.findByPlayer(mainplayer);
    }
}
