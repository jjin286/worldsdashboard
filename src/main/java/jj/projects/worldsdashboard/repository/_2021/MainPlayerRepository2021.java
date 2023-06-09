package jj.projects.worldsdashboard.repository._2021;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2021.MainPlayer2021;

public interface MainPlayerRepository2021 extends CrudRepository<MainPlayer2021, String>{
    MainPlayer2021 findByPlayer(String player);
    List<MainPlayer2021> findAll();
    List<MainPlayer2021> findByTeam(String team);
}
