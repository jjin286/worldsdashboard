package jj.projects.worldsdashboard.repository._2020;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2020.PlayInTeam2020;

public interface PlayInTeamRepository2020 extends CrudRepository<PlayInTeam2020, String>{
    PlayInTeam2020 findByTeam(String team);
}
