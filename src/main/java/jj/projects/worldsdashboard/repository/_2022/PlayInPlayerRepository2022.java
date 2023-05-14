package jj.projects.worldsdashboard.repository._2022;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2022.PlayInPlayer2022;

public interface PlayInPlayerRepository2022 extends CrudRepository<PlayInPlayer2022, String>{
    PlayInPlayer2022 findByPlayer(String player);
    List<PlayInPlayer2022> findAll();
}
