package jj.projects.worldsdashboard.controller._2022;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.MainPlayer2022;
import jj.projects.worldsdashboard.repository._2022.MainPlayerRepository2022;

@RestController
@CrossOrigin
public class MainPlayer2022Controller {
    private MainPlayerRepository2022 mainPlayerRepository2022;

    public MainPlayer2022Controller(MainPlayerRepository2022 mainPlayerRepository){
        this.mainPlayerRepository2022 = mainPlayerRepository;
    }

    @GetMapping("/mainPlayer/2022/{mainplayer}")
    public MainPlayer2022 getMainPlayer2022(@PathVariable String mainplayer) {
        return this.mainPlayerRepository2022.findByPlayer(mainplayer);
    }
}
