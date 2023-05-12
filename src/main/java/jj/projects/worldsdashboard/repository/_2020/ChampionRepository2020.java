package jj.projects.worldsdashboard.repository._2020;

import jj.projects.worldsdashboard.model._2020.Champion2020;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChampionRepository2020 extends CrudRepository <Champion2020, Integer>{

    Champion2020 findByChampion(String champion);

    List<Champion2020> findAll();
}
