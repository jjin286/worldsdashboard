package jj.projects.worldsdashboard.repository._2020;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2020.MainTeam2020;

public interface MainTeamRepository2020 extends CrudRepository<MainTeam2020, String>{
    MainTeam2020 findByTeam(String team);
}
