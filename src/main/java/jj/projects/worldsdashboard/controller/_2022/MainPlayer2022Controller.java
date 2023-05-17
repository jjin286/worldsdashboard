package jj.projects.worldsdashboard.controller._2022;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.MainPlayer2022;
import jj.projects.worldsdashboard.repository._2022.MainPlayerRepository2022;

@RestController
@CrossOrigin(origins = { "*" })
public class MainPlayer2022Controller {
    private MainPlayerRepository2022 mainPlayerRepository;

    public MainPlayer2022Controller(MainPlayerRepository2022 mainPlayerRepository){
        this.mainPlayerRepository = mainPlayerRepository;
    }

    @GetMapping("/2022/mainPlayer")
    public List<MainPlayer2022> getAllMainPlayer2022() {
        return this.mainPlayerRepository.findAll();
    }

    @GetMapping("/2022/mainPlayer/{mainplayer}")
    public MainPlayer2022 getMainPlayer2022(@PathVariable String mainplayer) {
        return this.mainPlayerRepository.findByPlayer(mainplayer);
    }

    @GetMapping(value="/2022/mainPlayer/findByTeam/{team}")
    public List<MainPlayer2022> getPlayersByTeam(@PathVariable String team) {
        return this.mainPlayerRepository.findByTeam(team);
    }
}
