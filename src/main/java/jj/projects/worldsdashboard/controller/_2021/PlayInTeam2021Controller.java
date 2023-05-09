package jj.projects.worldsdashboard.controller._2021;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.PlayInTeam2021;
import jj.projects.worldsdashboard.repository._2021.PlayInTeamRepository2021;

@RestController
@CrossOrigin
public class PlayInTeam2021Controller {
    private PlayInTeamRepository2021 playInTeamRepository2021;

    public PlayInTeam2021Controller(PlayInTeamRepository2021 playInTeamRepository){
        this.playInTeamRepository2021 = playInTeamRepository;
    }

    @GetMapping(value="/playInTeam/2021/{team}")
    public PlayInTeam2021 getPlayInTeam2021(@PathVariable String team) {
        return playInTeamRepository2021.findByTeam(team);
    }
    
}
