package jj.projects.worldsdashboard.controller._2020;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.MainTeam2020;
import jj.projects.worldsdashboard.repository._2020.MainTeamRepository2020;


@RestController
@CrossOrigin
public class MainTeam2020Controller {
    private MainTeamRepository2020 mainTeamRepository2020;

    public MainTeam2020Controller(MainTeamRepository2020 mainTeamRepository){
        this.mainTeamRepository2020 = mainTeamRepository;
    }

    @GetMapping(value="/mainTeam/2020/{team}")
    public MainTeam2020 getMainTeam2020(@PathVariable String team) {
        return mainTeamRepository2020.findByTeam(team);
    }
    
}
