import { React, useEffect, useState } from 'react';

export const TeamStatCard = ({stat}) =>{

    const [stats, setStats] = useState(stat);

    useEffect(
        () => {
            setStats({stat});
            console.log(stats[0]);
        }, [stat]
    );


    return(
        <div className='container'>
            <div className='row'>
                <div style={{padding: '0'}} className='col'>
                    <div className='statCard'>
                        <h5>Kills</h5>
                        <h3 style={{ color: "white"}}>{stats.kills}</h3>
                    </div>
                    <div className='statCard'>
                        <h5>Avg Gold</h5>
                    </div>
                    <div className='statCard'>
                        <h5>Assists</h5>

                    </div>
                    <div className='statCard'>
                        <h5>Damage Per Minute</h5>

                    </div>
                    <div className='statCard'>
                        <h5>Deaths</h5>

                    </div>
                    <div className='statCard'>
                        <h5>Damage Per Minute</h5>

                    </div>
                </div>
            </div>
        </div>
    );
}