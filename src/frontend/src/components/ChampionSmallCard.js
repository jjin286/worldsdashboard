import { React } from 'react';

export const ChampionSmallCard = ({champion}) => {
  return (
    <div className="ChampionSmallCard">
      <div className='d-flex flex-row card'>
        <div className='card-body blueSide'> 
          <h5>Blue side pick: {champion.sumBlueSide}</h5>
        </div>
        <div className='card-body blueSide'>
          <h5>Blue side win: {champion.winBlueSide}</h5>
        </div>
        <div className='card-body blueSide'>
          <h5>Blue side lose: {champion.loseBlueSide}</h5>
        </div>
        <div className='card-body blueSide'>
          <h5>Blue side winrate: {champion.winrateBlueSide}</h5>
        </div>
      </div>
      <div className='d-flex flex-row card'>
        <div className='card-body redSide'> 
          <h5>Red side pick: {champion.sumRedSide}</h5>
        </div>
        <div className='card-body redSide'>
          <h5>Red side win: {champion.winRedSide}</h5>
        </div>
        <div className='card-body redSide'>
          <h5>Red side lose: {champion.loseRedSide}</h5>
        </div>
        <div className='card-body redSide'>
          <h5>Red side winrate: {champion.winrateRedSide}</h5>
        </div>
      </div>
      <div className='d-flex flex-row card'>
        <div className='card-body'>
          <h5>Total bans: {champion.sumBans}</h5>
        </div>
        <div className='card-body'>
          <h5>Total pick/ban: {champion.sumPickBan}</h5>
        </div> 
      </div>
    </div>
  );
}


