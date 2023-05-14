package jj.projects.worldsdashboard.controller._2020;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2020.MainTeam2020;
import jj.projects.worldsdashboard.repository._2020.MainTeamRepository2020;


@RestController
@CrossOrigin(origins = { "*" })
public class MainTeam2020Controller {
    private MainTeamRepository2020 mainTeamRepository;

    public MainTeam2020Controller(MainTeamRepository2020 mainTeamRepository){
        this.mainTeamRepository = mainTeamRepository;
    }

    @GetMapping("/2020/mainTeam")
    public List<MainTeam2020> getAllMainTeam2020() {
        return this.mainTeamRepository.findAll();
    }

    @GetMapping(value="/2020/mainTeam/{team}")
    public MainTeam2020 getMainTeam2020(@PathVariable String team) {
        return mainTeamRepository.findByTeam(team);
    }

    
    
}
