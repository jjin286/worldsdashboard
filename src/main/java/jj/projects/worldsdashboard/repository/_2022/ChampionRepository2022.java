package jj.projects.worldsdashboard.repository._2022;

import jj.projects.worldsdashboard.model._2022.Champion2022;
import org.springframework.data.repository.CrudRepository;

public interface ChampionRepository2022 extends CrudRepository <Champion2022, Integer>{

    Champion2022 findByChampion(String champion);
}
