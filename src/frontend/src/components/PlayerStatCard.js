import { React } from 'react';

export const PlayerStatCard = ({stat}) => {
    
    return(
        <div className='container'>
            <div className='row'>
                <div style={{padding: '0'}} className='col'>
                    <div className='statCard'>
                        <h5>K/D/A</h5>
                        <h3 style={{ color: "white"}}>{stat.kills}/{stat.deaths}/{stat.assists}  ({stat.kda})</h3>
                    </div>
                    <div className='statCard'>
                        <div className='row'>
                            <div className='col-8'>
                                <h5>First Blood %</h5>
                                <h3 style={{ color: "white"}}>{stat.firstBloodRate}</h3>
                            </div>
                        </div>
                    </div>
                    <div className='statCard'>
                        <h5>Games Played</h5>
                        <h3 style={{ color: "white"}}>{stat.goldPerMinute}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Kill Participation</h5>
                        <h3 style={{ color: "white"}}>{stat.kp}</h3>
                    </div>
                </div>
                <div style={{paddingRight: '0'}}className='col'>
                    <div className='statCard'>
                        <h5>CS/M</h5>
                        <h3 style={{ color: "white"}}>{stat.cspm}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Kill Share</h5>
                        <h3 style={{ color: "white"}}>{stat.killShare}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Gold Diff @ 10</h5>
                        <h3 style={{ color: "white"}}>{stat.goldDiff10}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>XP Diff @ 10</h5>
                        <h3 style={{ color: "white"}}>{stat.xpDiff10}</h3>
                    </div>
                </div>
                <div style={{paddingRight: '0'}} className='col'>
                    <div className='statCard'>
                        <h5>CS Diff @ 10</h5>
                        <h3 style={{ color: "white"}}>{stat.csDiff10}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Shared Team Deaths</h5>
                        <h3 style={{ color: "white"}}>{stat.shareTeamDeaths}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>DMG/M</h5>
                        <h3 style={{ color: "white"}}>{stat.damagePerMinute}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Shared Damage</h5>
                        <h3 style={{ color: "white"}}>{stat.shareDamage}</h3>
                    </div>
                </div>
                <div style={{paddingRight: '0'}} className='col'>
                    <div className='statCard'>
                        <h5>Avg Gold/M</h5>
                        <h3 style={{ color: "white"}}>{stat.averageGoldPerMinute}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Shared Gold</h5>
                        <h3 style={{ color: "white"}}>{stat.goldShare}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Wards/M</h5>
                        <h3 style={{ color: "white"}}>{stat.wardsPerMinute}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Winrate</h5>
                        <h3 style={{ color: "white"}}>{stat.winrate}</h3>
                    </div>
                </div>
            </div>
        </div>
    );
}