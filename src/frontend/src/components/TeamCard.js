import { React } from 'react';

export const TeamCard = ({team, year}) => {
    // const winrate = player.winrate?.slice(0, -1);
    // const gamesWon = player.goldPerMinute * winrate / 100;
    // const gamesLost = player.goldPerMinute - gamesWon;

    return(
        <div className='TeamCard'>
            <div style={{marginBottom: '12px'}} className='playerCard row'>
                <div className='col-2'>
                    <img src={`/teamLogos/${team.team}.png`} width="200" height="200" alt=""/>
                </div>
                <div className='col-3'></div>
                <div className='col-4'>
                    {/* <hr style={{width: '1px', height: '20px', display: 'inline-block'}}/>    */}
                    <div style={{marginLeft: '50px'}}>
                        <h1 style={{ color: "white" }}>{team.team}</h1>
                        <h3 style={{ color: "white" }}>{team.wins}W-{team.loses}L</h3>
                    </div>
                </div>
            </div>         
        </div>
    );
}