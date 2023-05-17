import { React } from 'react';
import { PlayerStatCard } from './PlayerStatCard';

export const PlayerCard = ({player, year}) => {
    const winrate = player.winrate?.slice(0, -1);
    const gamesWon = Math.round(player.goldPerMinute * winrate / 100);
    const gamesLost = Math.round(player.goldPerMinute - gamesWon);

    return(
        <div className='container'>
            <div className='playerCard row'>
                <div className='col-2'>
                    <img src={`/playerImages/${player.player}${year}.png`} width="235" height="180"/>
                </div>
                <div className='col-3'>
                    {/* <hr style={{width: '1px', height: '20px', display: 'inline-block'}}/>    */}
                    <div style={{marginLeft: '50px'}}>
                        <h1 style={{ color: "white" }}>{player.player}</h1>
                        {

                        }
                        <h3><img src={`/images/${player.position}.svg`}/> {player.position}</h3>
                        <h3>{player.team}</h3>
                    </div>
                </div>
                <div style={{borderLeft: '1px solid #9E9EB1'}} className='col-2'></div>
                <div className='col-2'>  
                    <br/>                  
                    <h1 style={{ marginTop: '12px', padding : '0'}} >{gamesWon}W-{gamesLost}L</h1>
                    <h7 style={{ color: "white", paddingLeft : '5px'}}>{player.kills}/{player.deaths}/{player.assists}</h7>
                    <br/>
                    <h9 style={{ paddingLeft : '5px'}}>{player.kda} KDA</h9>  
                </div>
                <div className='col-2'>
                    <img src={`/teamLogos/${player.team}.png`} width="200" height="200"/>
                </div>
            </div>         
        </div>
    );
}