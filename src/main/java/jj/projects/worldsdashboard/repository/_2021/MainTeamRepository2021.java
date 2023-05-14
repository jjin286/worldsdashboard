package jj.projects.worldsdashboard.repository._2021;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2021.MainTeam2021;

public interface MainTeamRepository2021 extends CrudRepository<MainTeam2021, String>{
    MainTeam2021 findByTeam(String team);
    List<MainTeam2021> findAll();
}
