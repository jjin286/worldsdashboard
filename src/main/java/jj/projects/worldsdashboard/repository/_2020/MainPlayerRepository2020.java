package jj.projects.worldsdashboard.repository._2020;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2020.MainPlayer2020;

public interface MainPlayerRepository2020 extends CrudRepository<MainPlayer2020, String>{
    MainPlayer2020 findByPlayer(String player);
    List<MainPlayer2020> getByTeam(String team);
    List<MainPlayer2020> findAll();
}
