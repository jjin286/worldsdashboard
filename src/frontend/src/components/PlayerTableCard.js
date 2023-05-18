import { React, useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

export const PlayerTableCard = ({team, teamType, playerData}) => {
    const [currentPlayer, setCurrentPlayer] = useState(playerData);
    const { year } = useParams();

    useEffect(
        () => {
            setCurrentPlayer(playerData);
        }, [team, teamType, playerData]
    );
    
    return(
        <div className='PlayerTableCard'>
            <div className='container'>
                <table style={{width: '100%'}}>
                    <thead style={{color:'white'}}>
                        <tr>
                            <th>Player</th>
                            <th>KDA</th>
                            <th>Sh Kill</th>
                            <th>KP</th>
                            <th>Sh DMG</th>
                            <th>Sh Death</th>
                            <th>Sh Gold</th>
                        </tr>
                    </thead>
                    <tbody>
                        {currentPlayer.reduce((accumulator, currentValue) => {
                            if (currentValue.position === "Top") {
                                return(
                                <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                    <td>
                                        <div className='row'>
                                            <div className='col-9'>
                                                <img src={`/playerImages/${currentValue.player}${year}.png`} width="150" height="113" alt=""/>
                                                {teamType === 'mainTeam' 
                                                ? <a style={{color: 'white', textDecoration: 'none'}}href={`${year}/mainPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                : <a style={{color: 'white', textDecoration: 'none'}}href={`${year}/playInPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                }
                                            </div>
                                            <div className='col-2'>
                                                <img style={{marginTop: '30px'}} src={`/images/${currentValue.position}.svg`} width='32' height='32' alt=""/>
                                            </div>
                                        </div>
                                    </td>
                                    <td>{currentValue.kda}</td>
                                    <td>{currentValue.killShare}</td>
                                    <td>{currentValue.kp}</td>
                                    <td>{currentValue.shareDamage}</td>
                                    <td>{currentValue.shareTeamDeaths}</td>
                                    <td>{currentValue.goldShare}</td>
                                </tr>
                                );
                            }
                            return accumulator;
                        }, [])}

                        {currentPlayer.reduce((accumulator, currentValue) => {
                            if (currentValue.position === "Jungle") {
                                return(
                                <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                    <td>
                                        <div className='row'>
                                            <div className='col-9'>
                                                <img src={`/playerImages/${currentValue.player}${year}.png`} width="150" height="113" alt=""/>
                                                {teamType === 'mainTeam' 
                                                ? <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                : <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                }
                                            </div>
                                            <div className='col-2'>
                                                <img style={{marginTop: '30px'}} src={`/images/${currentValue.position}.svg`} width='32' height='32' alt=""/>
                                            </div>
                                        </div>
                                    </td>
                                    <td>{currentValue.kda}</td>
                                    <td>{currentValue.killShare}</td>
                                    <td>{currentValue.kp}</td>
                                    <td>{currentValue.shareDamage}</td>
                                    <td>{currentValue.shareTeamDeaths}</td>
                                    <td>{currentValue.goldShare}</td>
                                </tr>
                                );
                            }
                            return accumulator;
                        }, [])}

                        {currentPlayer.reduce((accumulator, currentValue) => {
                            if (currentValue.position === "Middle") {
                                return(
                                <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                    <td>
                                        <div className='row'>
                                            <div className='col-9'>
                                                <img src={`/playerImages/${currentValue.player}${year}.png`} width="150" height="113" alt=""/>
                                                {teamType === 'mainTeam' 
                                                ? <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                : <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                }
                                            </div>
                                            <div className='col-2'>
                                                <img style={{marginTop: '30px'}} src={`/images/${currentValue.position}.svg`} width='32' height='32' alt=""/>
                                            </div>
                                        </div>
                                    </td>
                                    <td>{currentValue.kda}</td>
                                    <td>{currentValue.killShare}</td>
                                    <td>{currentValue.kp}</td>
                                    <td>{currentValue.shareDamage}</td>
                                    <td>{currentValue.shareTeamDeaths}</td>
                                    <td>{currentValue.goldShare}</td>
                                </tr>
                                );
                            }
                            return accumulator;
                        }, [])}

                        {currentPlayer.reduce((accumulator, currentValue) => {
                            if (currentValue.position === "ADC") {
                                return(
                                <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                    <td>
                                        <div className='row'>
                                            <div className='col-9'>
                                                <img src={`/playerImages/${currentValue.player}${year}.png`} width="150" height="113" alt=""/>
                                                {teamType === 'mainTeam' 
                                                ? <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                : <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                }
                                            </div>
                                            <div className='col-2'>
                                                <img style={{marginTop: '30px'}} src={`/images/${currentValue.position}.svg`} width='32' height='32' alt=""/>
                                            </div>
                                        </div>
                                    </td>
                                    <td>{currentValue.kda}</td>
                                    <td>{currentValue.killShare}</td>
                                    <td>{currentValue.kp}</td>
                                    <td>{currentValue.shareDamage}</td>
                                    <td>{currentValue.shareTeamDeaths}</td>
                                    <td>{currentValue.goldShare}</td>
                                </tr>
                                );
                            }
                            return accumulator;
                        }, [])}

                        {currentPlayer.reduce((accumulator, currentValue) => {
                            if (currentValue.position === "Support") {
                                return(
                                <tr style={{backgroundColor: 'rgb(35, 35, 35)', color: 'white', textDecoration: 'none'}}>
                                    <td>
                                        <div className='row'>
                                            <div className='col-9'>
                                                <img src={`/playerImages/${currentValue.player}${year}.png`} width="150" height="113" alt=""/>
                                                {teamType === 'mainTeam' 
                                                ? <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                : <a style={{color: 'white', textDecoration: 'none'}}href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer/${currentValue.player}`}>{currentValue.player}</a>
                                                }
                                            </div>
                                            <div className='col-2'>
                                                <img style={{marginTop: '30px'}} src={`/images/${currentValue.position}.svg`} width='32' height='32' alt=""/>
                                            </div>
                                        </div>
                                    </td>
                                    <td>{currentValue.kda}</td>
                                    <td>{currentValue.killShare}</td>
                                    <td>{currentValue.kp}</td>
                                    <td>{currentValue.shareDamage}</td>
                                    <td>{currentValue.shareTeamDeaths}</td>
                                    <td>{currentValue.goldShare}</td>
                                </tr>
                                );
                            }
                            return accumulator;
                        }, [])}

                    </tbody>
                </table>
            </div>
        </div>
    );
}