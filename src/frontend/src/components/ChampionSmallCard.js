import { React } from 'react';

export const ChampionSmallCard = ({champion}) => {
  return (
    <div className="ChampionSmallCard">
      <p>Pick-ban Rate: {champion.pickBanRate}</p>
      <p>Pick Rate: {champion.pickRate}</p>
    </div>
  );
}


