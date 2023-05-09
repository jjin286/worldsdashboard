import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { ChampionLargeCard } from '../components/ChampionLargeCard'
import { ChampionSmallCard } from '../components/ChampionSmallCard'

export const ChampionPage = () => {

  const [champion, setChampion] = useState({});
  const { championName } = useParams();
  useEffect(
    () => {
      const fetchChampion = async () => {
        const response = await fetch(`http://localhost:8080/champion/${championName}`);
        const data = await response.json();
        setChampion(data);
      };
      fetchChampion();
    }, []
  );

  if(!champion || !champion.champion){
    return <h1>Champion not found</h1>
  }
  return (
    <div className="ChampionPage">
      <div className='d-block row'>
        <h1>{champion.champion}</h1>
        <img src='/championImages/miss fortune.jpeg'/>
      </div>
      <div className='row'>
        <ChampionLargeCard champion={champion}/>                                                              
        <ChampionSmallCard champion={champion}/>
        </div>
    </div>
  );
}


