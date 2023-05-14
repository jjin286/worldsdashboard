package jj.projects.worldsdashboard.controller._2021;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jj.projects.worldsdashboard.model._2021.MainTeam2021;
import jj.projects.worldsdashboard.repository._2021.MainTeamRepository2021;


@RestController
@CrossOrigin(origins = { "*" })
public class MainTeam2021Controller {
    private MainTeamRepository2021 mainTeamRepository;

    public MainTeam2021Controller(MainTeamRepository2021 mainTeamRepository){
        this.mainTeamRepository = mainTeamRepository;
    }

    @GetMapping("/2021/mainTeam")
    public List<MainTeam2021> getAllMainTeam2021() {
        return this.mainTeamRepository.findAll();
    }

    @GetMapping(value="/2021/mainTeam/{team}")
    public MainTeam2021 getMainTeam2021(@PathVariable String team) {
        return mainTeamRepository.findByTeam(team);
    }
    
}
