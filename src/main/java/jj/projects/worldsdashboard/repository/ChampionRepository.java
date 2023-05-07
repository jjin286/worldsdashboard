package jj.projects.worldsdashboard.repository;

import jj.projects.worldsdashboard.model.Champion;
import org.springframework.data.repository.CrudRepository;

public interface ChampionRepository extends CrudRepository <Champion, Integer>{

    Champion findByChampion(String champion);
}
