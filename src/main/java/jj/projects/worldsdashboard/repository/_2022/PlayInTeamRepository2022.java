package jj.projects.worldsdashboard.repository._2022;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2022.PlayInTeam2022;

public interface PlayInTeamRepository2022 extends CrudRepository<PlayInTeam2022, String>{
    PlayInTeam2022 findByTeam(String team);
    List<PlayInTeam2022> findAll();
}