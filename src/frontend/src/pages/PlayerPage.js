import { React, useEffect, useState } from 'react';
import { SideBar } from '../components/SideBar';
import { WorldsNavbar } from '../components/WorldsNavbar';
import { useParams } from 'react-router-dom';
import { PlayerCard } from '../components/PlayerCard';
import { PlayerStatCard } from '../components/PlayerStatCard';

export const PlayerPage = () => {
    const [player, setPlayer] = useState({});
    const { year, playerName, playerType } = useParams();
    
    useEffect(
        () => {
            const fetchPlayer = async () =>{
                console.log(`http://localhost:8080/${year}/${playerType}/${playerName}`);
                const response = await fetch(`http://localhost:8080/${year}/${playerType}/${playerName}`);
                const data = await response.json();
                setPlayer(data);
                console.log(player);
                console.log(`/playerImages/${player.player}_${year}.jpeg`);
            }

            fetchPlayer();
        }, [player, playerName, playerType, year]
    );
    
    
    if(!player || !player.player){
        return (
        <div className="PlayerPage" style={{backgroundColor: 'rgb(23,23,23)', overflow: 'hidden', textAlign: 'center' }}>
            <div className='row g-0'>
                <div className='col'>
                    <SideBar year={year}/>
                </div>
                <div className='col-10'>
                    <WorldsNavbar /> 
                    <h1 style={{ color: 'white'}}>Player not found</h1>
                </div>
            </div>
        </div>
        );  
    }

    return(
        <div className="PlayerPage" style={{backgroundColor: 'rgb(23,23,23)', overflow: 'hidden'}}>
            <div className='row g-0'>
                <div className='col'>
                    <SideBar year={year}/>
                </div>
                <div className='col-10'>
                    <WorldsNavbar /> 
                    <PlayerCard player={player} year={year}/>
                    <PlayerStatCard stat={player} />
                </div>
            </div>
        </div>
    );
}