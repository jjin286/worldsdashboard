package jj.projects.worldsdashboard.repository._2022;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2022.MainTeam2022;

public interface MainTeamRepository2022 extends CrudRepository<MainTeam2022, String>{
    MainTeam2022 findByTeam(String team);
    List<MainTeam2022> findAll();
}
