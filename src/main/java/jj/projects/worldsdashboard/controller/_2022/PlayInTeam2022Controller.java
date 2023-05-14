package jj.projects.worldsdashboard.controller._2022;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.PlayInTeam2022;
import jj.projects.worldsdashboard.repository._2022.PlayInTeamRepository2022;

@RestController
@CrossOrigin(origins = { "*" })
public class PlayInTeam2022Controller {
    private PlayInTeamRepository2022 playInTeamRepository;

    public PlayInTeam2022Controller(PlayInTeamRepository2022 playInTeamRepository){
        this.playInTeamRepository = playInTeamRepository;
    }

    @GetMapping("/2022/playInTeam")
    public List<PlayInTeam2022> getAllPlayInTeam2022() {
        return this.playInTeamRepository.findAll();
    }

    @GetMapping(value="/2022/playInTeam/{team}")
    public PlayInTeam2022 getPlayInTeam2022(@PathVariable String team) {
        return playInTeamRepository.findByTeam(team);
    }
    
}
