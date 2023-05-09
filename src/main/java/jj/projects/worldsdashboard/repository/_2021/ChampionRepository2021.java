package jj.projects.worldsdashboard.repository._2021;

import jj.projects.worldsdashboard.model._2021.Champion2021;
import org.springframework.data.repository.CrudRepository;

public interface ChampionRepository2021 extends CrudRepository <Champion2021, Integer>{

    Champion2021 findByChampion(String champion);
}
