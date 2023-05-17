package jj.projects.worldsdashboard.repository._2022;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2022.MainPlayer2022;

public interface MainPlayerRepository2022 extends CrudRepository<MainPlayer2022, String>{
    MainPlayer2022 findByPlayer(String player);
    List<MainPlayer2022> findAll();
    List<MainPlayer2022> findByTeam(String team);
}
