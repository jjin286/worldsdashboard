package jj.projects.worldsdashboard.controller._2021;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.MainPlayer2021;
import jj.projects.worldsdashboard.repository._2021.MainPlayerRepository2021;

@RestController
@CrossOrigin(origins = { "*" })
public class MainPlayer2021Controller {
    private MainPlayerRepository2021 mainPlayerRepository;

    public MainPlayer2021Controller(MainPlayerRepository2021 mainPlayerRepository){
        this.mainPlayerRepository = mainPlayerRepository;
    }

    @GetMapping("/2021/mainPlayer")
    public List<MainPlayer2021> getAllMainPlayer2021() {
        return this.mainPlayerRepository.findAll();
    }

    @GetMapping("/2021/mainPlayer/{mainplayer}")
    public MainPlayer2021 getMainPlayer2021(@PathVariable String mainplayer) {
        return this.mainPlayerRepository.findByPlayer(mainplayer);
    }
}
