package jj.projects.worldsdashboard.repository._2021;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2021.PlayInPlayer2021;

public interface PlayInPlayerRepository2021 extends CrudRepository<PlayInPlayer2021, String>{
    PlayInPlayer2021 findByPlayer(String player);
    List<PlayInPlayer2021> findAll();
}
