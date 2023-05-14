package jj.projects.worldsdashboard.repository._2022;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.projects.worldsdashboard.model._2022.Champion2022;

public interface ChampionRepository2022 extends CrudRepository <Champion2022, Integer>{

    Champion2022 findByChampion(String champion);
    
    List<Champion2022> findAll();
}
