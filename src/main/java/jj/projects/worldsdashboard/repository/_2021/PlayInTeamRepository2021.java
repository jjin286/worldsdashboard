package jj.projects.worldsdashboard.repository._2021;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2021.PlayInTeam2021;

public interface PlayInTeamRepository2021 extends CrudRepository<PlayInTeam2021, String>{
    PlayInTeam2021 findByTeam(String team);
}
