import { React  } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { CircularProgressbar} from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';


export const ChampionLargeCard = ({champion}) => {
  
  if(champion.banRate){
    const winrate = champion.winrateTotal.slice(0, -1);
    const pickrate = champion.pickRate.slice(0, -1);
    const banrate = champion.banRate.slice(0, -1);
    const pickbanrate = champion.pickBanRate.slice(0, -1);

    return (
      <div className="ChampionLargeCard">
        <div className="d-flex flex-row justify-content-center ">
          <div className='stat-box col-2 fs-5 '>
            <p>Winrate </p>
            <CircularProgressbar value={winrate} text={`${winrate}%`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Pickrate</p>
            <CircularProgressbar value={pickrate} text={`${pickrate}%`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Banrate</p>
            <CircularProgressbar value={banrate} text={`${banrate}%`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Pick/Ban</p>
            <CircularProgressbar value={pickbanrate} text={`${pickbanrate}%`} />
          </div>
        </div>
        <div className='d-flex flex-row'>
            <div className='stat-box col fs-5'>
              <p>Total pick/ban <br/> {champion.sumPickBan}</p>
            </div> 
            <div className='stat-box col fs-5'>
              <p>Total bans <br/> {champion.sumBans}</p>
            </div>
            <div className='stat-box col fs-5 '>
              <p>Pick Count <br/> {champion.sumTotal}</p>
            </div>
          </div>
      </div>
    );
  } else {
    const winrate = champion.winrateTotal.slice(0, -1);
    const pickrate = champion.pickRate.slice(0, -1);

    return (
      <div className="ChampionLargeCard">
        <div className="d-flex flex-row justify-content-center ">
          <div className='stat-box col-2 fs-5 '>
            <p>Winrate </p>
            <CircularProgressbar value={winrate} text={`${winrate}%`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Pickrate</p>
            <CircularProgressbar value={pickrate} text={`${pickrate}%`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Banrate</p>
            <CircularProgressbar value={0} text={`N/A`} />
          </div>
          <div className='stat-box col-2 fs-5'>
            <p>Pick/Ban</p>
            <CircularProgressbar value={0} text={`N/A`} />
          </div>
        </div>
        <div className='d-flex flex-row'>
            <div className='stat-box col fs-5'>
              <p>Total pick/ban <br/> N/A</p>
            </div> 
            <div className='stat-box col fs-5'>
              <p>Total bans <br/> N/A</p>
            </div>
            <div className='stat-box col fs-5 '>
              <p>Pick Count <br/> {champion.sumTotal}</p>
            </div>
          </div>
      </div>
    );
  }
  
}


