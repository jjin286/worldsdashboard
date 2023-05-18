import { React } from 'react';
import { DropDown } from '../components/DropDown';

export const LandingPage = () => {

    return(
        <div>
            <main>
                <div id='topBar'>
                    <div className='row'>
                        <div className='col'>
                            <img style={{margin:'12px 0 12px 0'}} src={`/images/Worldslogo.png`} width='40' height='40' alt=""/>
                        </div>
                        <div className='col'>
                            <DropDown year="2020"/>
                        </div>
                        <div className='col'>
                            <DropDown year="2021"/>
                        </div>
                        <div className='col'>
                            <DropDown year="2022"/>
                        </div>
                    </div>
                        
                </div>
                <section className="parallax bg1">
                    <h1>Worlds Statistics</h1>
                </section>
                <section className="no-parallax">
                    <h1>Compare statistics from the teams and players from the League of Legends Worlds event 2020, 2021, and 2022!</h1>
                </section>
                <section className="parallax bg2">
                    <h1>Worlds 2020</h1>
                </section>
                <section style={{textAlign: 'left', alignItems: 'left', justifyContent: 'left', display:'grid'}} className="no-parallax">
                    <div className='row'>
                        <h1>Worlds 2020 Tournament Winner</h1>
                        
                    </div>
                    <div style={{textAlign: 'center'}} className='row'>
                        <div className='col-4'>
                            <img style={{width:'80%', height: 'auto'}} src={`/teamLogos/DAMWONlogo.png`} alt=""/>
                            <div className='rosterButton'><a style={{padding: '15px'}} href={`http://localhost:3000/2020/team/mainTeam/DWG KIA`} className='text-decoration-none d-flex align-itemcenter text-white ms-3 mt-2'>View Roster</a></div>
                        </div>
                        <div className='col-8'>
                            <img style={{width:'85%', height: 'auto', borderRadius: '50px'}} src={`/images/worldswinner2020.jpeg`} alt=""/> 
                        </div>
                        
                    </div>
                </section>
                <section className="parallax bg3">
                    <h1>Worlds 2021</h1>
                </section>
                <section style={{textAlign: 'left', alignItems: 'left', justifyContent: 'left', display:'grid'}} className="no-parallax">
                    <div className='row'>
                        <h1>Worlds 2021 Tournament Winner</h1>
                        
                    </div>
                    <div style={{textAlign: 'center'}} className='row'>
                        <div className='col-4'>
                            <img style={{width:'80%', height: 'auto'}} src={`/teamLogos/EDward Gaming.png`} alt=""/>
                            <div className='rosterButton' ><a style={{padding: '15px'}} href={`http://localhost:3000/2021/team/mainTeam/EDward Gaming`} className='text-decoration-none d-flex align-itemcenter text-white ms-3 mt-2'>View Roster</a></div>
                        </div>
                        <div className='col-8'>
                            <img style={{width:'85%', height: 'auto', borderRadius: '50px'}} src={`/images/worldswinner2021.png`} alt=""/> 
                        </div>
                        
                    </div>
                </section>
                <section className="parallax bg4">
                    <h1>Worlds 2022</h1>
                </section>
                <section style={{textAlign: 'left', alignItems: 'left', justifyContent: 'left', display:'grid'}} className="no-parallax">
                    <div className='row'>
                        <h1>Worlds 2022 Tournament Winner</h1>
                        
                    </div>
                    <div style={{textAlign: 'center'}} className='row'>
                        <div className='col-4'>
                            <img style={{width:'80%', height: 'auto'}} src={`/teamLogos/DRX.png`} alt=""/>
                            <div className='rosterButton'><a style={{padding: '15px'}} href={`http://localhost:3000/2022/team/mainTeam/DRX`} className='text-decoration-none d-flex align-itemcenter text-white ms-3 mt-2'>View Roster</a></div>
                        </div>
                        <div className='col-8'>
                            <img style={{width:'85%', height: 'auto', borderRadius: '50px'}} src={`/images/worldswinner2022.png`} alt=""/> 
                        </div>
                        
                    </div>
                </section>
            </main>
        </div>
        // <div style={{padding:0}} className='container-fluid'>
        //     <div style={{textAlign: 'center', backgroundColor: 'rgb(35, 35, 35)'}}>
        //         <img style={{margin:'12px 0 12px 0'}} src={`/images/Worldslogo.png`} width='50' height='50'/>
        //     </div>
        //     <div>
        //         <img style={{width:'100%', height:'auto'}} className="low-opacity-bg-image" src={`/images/worldstrophy.jpeg`}/>
        //     </div>
        //     <div>
        //         <img style={{width:'100%', height:'auto'}} className="low-opacity-bg-image" src={`/images/worldstadium.png`}/>
        //     </div>
        // </div>
    );
}