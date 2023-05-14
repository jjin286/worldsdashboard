package jj.projects.worldsdashboard.controller._2020;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.PlayInTeam2020;
import jj.projects.worldsdashboard.repository._2020.PlayInTeamRepository2020;

@RestController
@CrossOrigin(origins = { "*" })
public class PlayInTeam2020Controller {
    private PlayInTeamRepository2020 playInTeamRepository;

    public PlayInTeam2020Controller(PlayInTeamRepository2020 playInTeamRepository){
        this.playInTeamRepository = playInTeamRepository;
    }

    @GetMapping("/2020/playInTeam")
    public List<PlayInTeam2020> getAllPlayInTeam2020() {
        return this.playInTeamRepository.findAll();
    }

    @GetMapping(value="/2020/playInTeam/{team}")
    public PlayInTeam2020 getPlayInTeam2020(@PathVariable String team) {
        return playInTeamRepository.findByTeam(team);
    }
    
}
