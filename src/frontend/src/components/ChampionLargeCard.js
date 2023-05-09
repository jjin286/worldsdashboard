import { React } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

export const ChampionLargeCard = ({champion}) => {
  return (
    <div className="ChampionLargeCard">
      <div className="d-flex flex-row card">
        <div className='card-body'>
          <h3>Pick Count: {champion.sumTotal}</h3>
        </div>
        <div className='card-body'>
          <h3>Winrate: {champion.winrateTotal}</h3>
        </div>
        <div className='card-body'>
          <h3>Pickrate: {champion.pickRate}</h3>
        </div>
        <div className='card-body'>
          <h3>Banrate: {champion.banRate}</h3>
        </div>
        <div className='card-body'>
          <h3>Pick/Ban Pressence: {champion.pickBanRate}</h3>
        </div>
      </div>
    </div>
  );
}


