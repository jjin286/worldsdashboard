package jj.projects.worldsdashboard.controller._2022;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.PlayInTeam2022;
import jj.projects.worldsdashboard.repository._2022.PlayInTeamRepository2022;

@RestController
@CrossOrigin
public class PlayInTeam2022Controller {
    private PlayInTeamRepository2022 playInTeamRepository2022;

    public PlayInTeam2022Controller(PlayInTeamRepository2022 playInTeamRepository){
        this.playInTeamRepository2022 = playInTeamRepository;
    }

    @GetMapping(value="/playInTeam/2022/{team}")
    public PlayInTeam2022 getPlayInTeam2022(@PathVariable String team) {
        return playInTeamRepository2022.findByTeam(team);
    }
    
}
