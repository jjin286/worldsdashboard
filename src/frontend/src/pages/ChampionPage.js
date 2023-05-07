import { React, useEffect, useState } from 'react';
import { ChampionLargeCard } from '../components/ChampionLargeCard'
import { ChampionSmallCard } from '../components/ChampionSmallCard'

export const ChampionPage = () => {

  const [champion, setChampion] = useState({});

  useEffect(
    () => {
      const fetchChampion = async () => {
        const response = await fetch('http://localhost:8080/champion/Jinx');
        const data = await response.json();
        setChampion(data);
      };
      fetchChampion();
    }, []
  );

  return (
    <div className="ChampionPage">
      <h1>{champion.champion}</h1>
      <ChampionSmallCard champion={champion}/>
      
    </div>
  );
}


