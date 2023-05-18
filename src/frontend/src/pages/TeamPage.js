import { React, useState, useEffect } from 'react';
import { SideBar } from '../components/SideBar';
import { WorldsNavbar } from '../components/WorldsNavbar';
import { useParams } from 'react-router-dom';
import { TeamCard } from '../components/TeamCard';
import { PlayerTableCard } from '../components/PlayerTableCard';
 

export const TeamPage = () => {
    const { year, teamName, teamType } = useParams();
    const [teams, setTeams] = useState({});
    const [players, setPlayers] = useState([{}]);

    useEffect(
        () => {
            const fetchTeam = async () => {
                // console.log(`http://localhost:8080/${year}/${teamType}/${teamName}`);
                const response = await fetch(`http://localhost:8080/${year}/${teamType}/${teamName}`);
                const data = await response.json();
                setTeams(data);
                console.log(teams.team);
            }
            fetchTeam();

            const fetchPlayers = async () => {   
                // console.log(`http://localhost:8080/${year}/mainPlayer/findByTeam/${teamName}`);
                const response = await fetch( teamType === "mainTeam" ? `http://localhost:8080/${year}/mainPlayer/findByTeam/${teamName}` : `http://localhost:8080/${year}/playInPlayer/findByTeam/${teamName}`);
                const data = await response.json();
                setPlayers(data);
                // console.log(players);
            }
            fetchPlayers();
            }, [teamName, teamType, teams.team, year]
    );

    const findHighest = (field) => {
        const copyPlayers = [...players];
        let highest = copyPlayers[0];
        console.log(highest[field]);
        copyPlayers.forEach( player => {
            if(player[field] > highest[field]){
                highest = player;
            }
        })
        return highest;
        
    }

    if(!teams.team){
        return(
            <div  className="TeamPage">
                <div className='row g-0'>
                    <div className='col-2'>
                        <SideBar year={year}/>
                    </div>
                    <div className='col-10'>
                        <WorldsNavbar />'
                        <h1 style={{color: 'white', textAlign:'center'}}>Team not found</h1>
                    </div>
                </div>
            </div>  
            );
    }

    return(
        <div  className="TeamPage">
            <div className='row g-0'>
                <div className='col-2'>
                    <SideBar year={year}/>
                </div>
                <div className='col-10'>
                    <WorldsNavbar />
                    <div className='row'>
                        <div style={{margin: '0 12px 0 40px'}} className='col-5'>
                            <TeamCard team={teams} year={year}/>
                            <div style={{marginLeft: '10px', marginRight: '10px'}} className='row'>
                                <div style={{padding: '0'}} className='col'>
                                    <div className=''>
                                        <div className='row'>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Kills</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("kills").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("kills").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("kills").kills}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Deaths</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("deaths").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("deaths").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("deaths").deaths}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Assists</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("assists").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("assists").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("assists").assists}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Gold Per Minute</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("averageGoldPerMinute").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("averageGoldPerMinute").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("averageGoldPerMinute").averageGoldPerMinute}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Damage Per Minute</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("damagePerMinute").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("damagePerMinute").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("damagePerMinute").damagePerMinute}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style={{textAlign: 'center'}} className='statCard col'>
                                                <p style={{margin: 0}}>Most Kill Participation</p>
                                                <img style={{marginBottom: '5px'}}src={`/playerImages/${findHighest("kp").player}${year}.png`} width="150" height="120" alt=""/>
                                                <div className='row'>
                                                    <div className='col'>
                                                        <h5>{findHighest("kp").player}</h5>
                                                    </div>
                                                    <div className='col'>
                                                        <h5 style={{ color: "white"}}>{findHighest("kp").kp}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className='col-6'>
                            <PlayerTableCard team={teams} teamType={teamType} playerData={players}/>
                        </div>
                    </div>
                    <div style={{marginTop: '12px', marginLeft: '35px', marginRight: '50px'}} className='row'>
                        <div style={{paddingLeft: '2px', paddingRight: '2px'}} className='col'>
                            <table>
                                <thead style={{backgroundColor: '#282830'}}>                               
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Avg Game Length</td>
                                        <td>{teams.averageGameDuration}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Combined Team Kills</td>
                                        <td>{teams.combinedKillsPerMinute}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Gold Rating</td>
                                        <td>{teams.goldPercentRating}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Spent Gold Difference</td>
                                        <td>{teams.goldSpentDifference}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Early Game Rating</td>
                                        <td>{teams.earlyGameRating}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style={{paddingLeft: '2px', paddingRight: '2px'}} className='col'>
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Mid-Late Rating</td>
                                        <td>{teams.midLateRating}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Gold Difference @ 15</td>
                                        <td>{teams.goldDiff15}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>First Blood Rate</td>
                                        <td>{teams.firstBloodRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>First Tower Rate</td>
                                        <td>{teams.firstTowerRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Turret Plates Destroyed</td>
                                        <td>{teams.turrentPlatesDestroyed}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style={{paddingLeft: '2px', paddingRight: '2px'}} className='col'>
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Rift Herald Rate</td>
                                        <td>{teams.riftHeraldRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>First Dragon Rate</td>
                                        <td>{teams.firstDragonRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Dragon Control Rate</td>
                                        <td>{teams.dragonControlRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Elder Dragon Rate</td>
                                        <td>{teams.elderDragonRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>First Baron Rate</td>
                                        <td>{teams.firstBaronRate}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style={{paddingLeft: '2px', paddingRight: '2px'}} className='col'>
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Baron Control Rate</td>
                                        <td>{teams.baronControlRate}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Lane Control</td>
                                        <td>{teams.laneControl}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Jungle Control</td>
                                        <td>{teams.jungleControl}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Wards Per Minute</td>
                                        <td>{teams.wardsPerMinute}</td>
                                        
                                    </tr>
                                    <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>Control Wards Per Minute</td>
                                        <td>{teams.controlWardsPerMinute}</td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                                    {/* <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                        <td>355</td>
                                        <td>wardsClearedPerMinute</td>
                                        
                                    </tr> */}
                                        
                    </div>
                </div>
            </div>
        </div>
    );
}