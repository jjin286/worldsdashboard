package jj.projects.worldsdashboard.controller._2020;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.MainPlayer2020;
import jj.projects.worldsdashboard.repository._2020.MainPlayerRepository2020;

@RestController
@CrossOrigin(origins = { "*" })
public class MainPlayer2020Controller {
    private MainPlayerRepository2020 mainPlayerRepository;

    public MainPlayer2020Controller(MainPlayerRepository2020 mainPlayerRepository){
        this.mainPlayerRepository = mainPlayerRepository;
    }

    @GetMapping("/2020/mainPlayer")
    public List<MainPlayer2020> getAllMainPlayer2020() {
        return this.mainPlayerRepository.findAll();
    }

    @GetMapping("/2020/mainPlayer/{mainplayer}")
    public MainPlayer2020 getMainPlayer2020(@PathVariable String mainplayer) {
        return this.mainPlayerRepository.findByPlayer(mainplayer);
    }

    // @GetMapping("/2020/team/{team}/players")
    // public List<MainPlayer2020> getMainPlayer2020FromTeam(@PathVariable String team) {
    //     return this.mainPlayerRepository.getByTeam(team);
    // }

    @GetMapping(value="/2020/mainPlayer/findByTeam/{team}")
    public List<MainPlayer2020> getPlayersByTeam(@PathVariable String team) {
        return this.mainPlayerRepository.findByTeam(team);
    }
    
}
