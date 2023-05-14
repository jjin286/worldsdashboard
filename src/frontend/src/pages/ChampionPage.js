import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { ChampionLargeCard } from '../components/ChampionLargeCard'
import { ChampionSmallCard } from '../components/ChampionSmallCard'
import { WorldsNavbar } from '../components/WorldsNavbar';
import { SideBar } from '../components/SideBar';

export const ChampionPage = () => {

  const [champion, setChampion] = useState({});
  const { championName, year } = useParams();
  useEffect(
    () => {
      const fetchChampion = async () => {
        const response = await fetch(`http://localhost:8080/${year}/champion/${championName}`);
        const data = await response.json();
        setChampion(data);
      };
      fetchChampion();
    }, [year]
  );

  if(!champion || !champion.champion){
    return (
      <div className="ChampionPage" style={{backgroundColor: 'rgb(23,23,23)', overflow: 'hidden'}}>
          <div className='row g-0'>
              <div className='col'>
                  <SideBar year={year}/>
              </div>
              <div className='col-10'>
                  <WorldsNavbar /> 
                  <h1 style={{ color: 'white', paddingLeft : '20px'}}>Champion not found</h1>
              </div>
          </div>
      </div>
      );  
  }
  return (
    <div className="ChampionPage">
      <div id='container'>
        <div className='row g-0'>
          <div className='col'>
            <SideBar year={year}/>
          </div>
          
          <div className='col-10'>
            <WorldsNavbar />
            <div className='row g-0'>
              <div className='ps-5 col-4'>
                <h1>{champion.champion}</h1>
                <img className='fit-image-right' src={"/championImages/" + champion.champion + ".jpeg"} />
              </div>
              <div className='col-1'></div>
              <div className='stats col-6'>
                <h1>Statistics</h1>
                <ChampionLargeCard champion={champion}/>                                                              
                <ChampionSmallCard champion={champion}/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}


