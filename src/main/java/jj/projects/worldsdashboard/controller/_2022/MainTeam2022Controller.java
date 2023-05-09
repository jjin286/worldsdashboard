package jj.projects.worldsdashboard.controller._2022;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.MainTeam2022;
import jj.projects.worldsdashboard.repository._2022.MainTeamRepository2022;


@RestController
@CrossOrigin
public class MainTeam2022Controller {
    private MainTeamRepository2022 mainTeamRepository2022;

    public MainTeam2022Controller(MainTeamRepository2022 mainTeamRepository){
        this.mainTeamRepository2022 = mainTeamRepository;
    }

    @GetMapping(value="/mainTeam/2022/{team}")
    public MainTeam2022 getMainTeam2022(@PathVariable String team) {
        return mainTeamRepository2022.findByTeam(team);
    }
    
}
