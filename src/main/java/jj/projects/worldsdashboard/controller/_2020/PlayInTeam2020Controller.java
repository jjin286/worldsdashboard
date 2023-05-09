package jj.projects.worldsdashboard.controller._2020;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.PlayInTeam2020;
import jj.projects.worldsdashboard.repository._2020.PlayInTeamRepository2020;

@RestController
@CrossOrigin
public class PlayInTeam2020Controller {
    private PlayInTeamRepository2020 playInTeamRepository2020;

    public PlayInTeam2020Controller(PlayInTeamRepository2020 playInTeamRepository){
        this.playInTeamRepository2020 = playInTeamRepository;
    }

    @GetMapping(value="/playInTeam/2020/{team}")
    public PlayInTeam2020 getPlayInTeam2020(@PathVariable String team) {
        return playInTeamRepository2020.findByTeam(team);
    }
    
}
