import { React } from 'react';
import { CircularProgressbar} from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';

export const ChampionSmallCard = ({champion}) => {
  const bluewinrate = champion.winrateBlueSide.slice(0,-1);
  const redwinrate = champion.winrateRedSide.slice(0,-1);
  return (
    <div className="ChampionSmallCard">
      <div className='row'>
        <div className='d-flex flex-column col-6'>
          <div className='row'>
            <div className='col-6 pt-4'>
              <div className='stat-box fs-5 blueSide'>
                <p>Blue side winrate</p>
                <CircularProgressbar value={bluewinrate} text={`${bluewinrate}%`} />
              </div>
            </div>
            <div className='col'>
              <div className='stat-box col fs-5 blueSide'> 
                <p>Blue side pick <br/> {champion.sumBlueSide}</p>
              </div>
              <div className='stat-box col fs-5 blueSide'>
                <p>Blue side win <br/> {champion.winBlueSide}</p>
              </div>
              <div className='stat-box col fs-5 blueSide'>
                <p>Blue side lose <br/> {champion.loseBlueSide}</p>
              </div>
            </div>
          </div>
        </div>
        <div className='d-flex flex-column col-6'>
          <div className='row'>
            <div className='col'>
              <div className='stat-box col fs-5 redSide'> 
                <p>Red side pick <br/> {champion.sumRedSide}</p>
              </div>
              <div className='stat-box col fs-5 redSide'>
                <p>Red side win <br/> {champion.winRedSide}</p>
              </div>
              <div className='stat-box col fs-5 redSide'>
                <p>Red side lose <br/> {champion.loseRedSide}</p>
              </div>
            </div>
            <div className='col-6 pt-4'>
              <div className='stat-box fs-5 redSide'>
                <p>Red side winrate</p>
                <CircularProgressbar value={redwinrate} text={`${redwinrate}%`} />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}


