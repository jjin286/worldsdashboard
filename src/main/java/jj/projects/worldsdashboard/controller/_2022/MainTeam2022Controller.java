package jj.projects.worldsdashboard.controller._2022;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2022.MainTeam2022;
import jj.projects.worldsdashboard.repository._2022.MainTeamRepository2022;


@RestController
@CrossOrigin(origins = { "*" })
public class MainTeam2022Controller {
    private MainTeamRepository2022 mainTeamRepository;

    public MainTeam2022Controller(MainTeamRepository2022 mainTeamRepository){
        this.mainTeamRepository = mainTeamRepository;
    }

    @GetMapping("/2022/mainTeam")
    public List<MainTeam2022> getAllMainTeam2022() {
        return this.mainTeamRepository.findAll();
    }

    @GetMapping(value="/2022/mainTeam/{team}")
    public MainTeam2022 getMainTeam2022(@PathVariable String team) {
        return mainTeamRepository.findByTeam(team);
    }
    
}
