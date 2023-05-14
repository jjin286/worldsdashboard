package jj.projects.worldsdashboard.controller._2021;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.PlayInTeam2021;
import jj.projects.worldsdashboard.repository._2021.PlayInTeamRepository2021;

@RestController
@CrossOrigin(origins = { "*" })
public class PlayInTeam2021Controller {
    private PlayInTeamRepository2021 playInTeamRepository;

    public PlayInTeam2021Controller(PlayInTeamRepository2021 playInTeamRepository){
        this.playInTeamRepository = playInTeamRepository;
    }

    @GetMapping("/2021/playInTeam")
    public List<PlayInTeam2021> getAllPlayInTeam2021() {
        return this.playInTeamRepository.findAll();
    }

    @GetMapping(value="/2021/playInTeam/{team}")
    public PlayInTeam2021 getPlayInTeam2021(@PathVariable String team) {
        return playInTeamRepository.findByTeam(team);
    }
    
}
