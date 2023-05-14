package jj.projects.worldsdashboard.repository._2020;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2020.PlayInPlayer2020;

public interface PlayInPlayerRepository2020 extends CrudRepository<PlayInPlayer2020, String>{
    PlayInPlayer2020 findByPlayer(String player);
    List<PlayInPlayer2020> findAll();
}
