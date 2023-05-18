import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { WorldsNavbar } from '../components/WorldsNavbar';
import { SideBar } from '../components/SideBar';
import 'bootstrap/dist/css/bootstrap.min.css';


export const AllChampionPage = () => {

  const [allChampion, setAllChampion] = useState([]);
  const [sortBy, setSortBy] = useState({field: "id", ascending: true});
  const { year } = useParams();

    useEffect(
        () => {

        const fetchAllChampion = async () => {
            const response = await fetch(`https://worldsstatistics-backend.herokuapp.com/${year}/champion`);
            const data = await response.json();
            setAllChampion(data);

            console.log("Store: " + allChampion);
        };
        
        fetchAllChampion();

        }, [allChampion, year]
    );

    useEffect(
        () => {
            const currentChampion = [...allChampion];
        
            const sortedChampion = currentChampion.sort((a, b) => {
                if(sortBy.field === "winrateTotal" || sortBy.field === "pickRate" || sortBy.field === "banRate") {
                    return parseFloat(a[sortBy.field].slice(0, -1)) - parseFloat(b[sortBy.field].slice(0, -1));
                } else if ( sortBy.field === "id" || sortBy.field === "sumTotal") {
                    return parseInt(a[sortBy.field]) - parseInt(b[sortBy.field]);
                } else {
                    return a[sortBy.field].localeCompare(b[sortBy.field]);
                }
            });
        
            setAllChampion( 
                sortBy.ascending ? sortedChampion : sortedChampion.reverse()
            );
        }, [allChampion, sortBy]
    );

    const onClickSort = (key, ascending) => {
        setSortBy({ field: key, ascending: ascending });
    };

  if(!allChampion){
    return <h1>Champion not found</h1>
  }
  
  return (
    <div className="AllChampionPage">
        <div className='row g-0'>
            <div className='col-2'>
                <SideBar year={year}/>
            </div>
            <div className='col-10'>
                <WorldsNavbar />
                <h1 style={{ color: 'white', padding: '0 0 0 50px'}}>{year} Champions</h1>
                <div className="championTable p-5">
                    <table>
                        <thead className="rounded-top" style={{background:'#282830', borderCollapse: 'collapse', borderRadius:10}}>
                            <tr>
                                <th style={{width:'1%'}} onClick={() => onClickSort("id", !sortBy.ascending)}>#</th>
                                <th style={{width:'15%'}} onClick={() => onClickSort("champion", !sortBy.ascending)}>Champion</th>
                                <th style={{width:'4%', background:'#282830'}} onClick={() => onClickSort("sumTotal", !sortBy.ascending)}>Total Played</th>
                                <th style={{width:'20%', padding: '0 15px'}} onClick={() => onClickSort("winrateTotal", !sortBy.ascending)}>Win Rate</th>
                                <th style={{width:'20%', padding: '0 15px'}} onClick={() => onClickSort("pickRate", !sortBy.ascending)}>Pick Rate</th>
                                <th style={{width:'4%'}} onClick={() => onClickSort("banRate", !sortBy.ascending)}>Ban Rate</th>
                            </tr>
                        </thead>
                        <tbody>
                            {allChampion.map((champ) => (
                                <tr>
                                    <td>{champ.id}</td>
                                    <td>
                                        <a className="text-decoration-none" style={{color:'white'}} href={"/" + year + "/champion/" + champ.champion}>
                                            <img src={"/championIcon/" + champ.champion + ".jpeg"} width="32" height="32" alt=""/>
                                            {champ.champion}
                                        </a>
                                    </td>
                                    <td style={{background:'#282830'}}>{champ.sumTotal}</td>
                                    <td style={{padding: '0 15px'}}>
                                        <div className="progress" style={{height: '3px'}}>
                                            <div className="progress-bar" role="progressbar" style={{width: champ.winrateTotal}} aria-valuenow={champ.winrateTotal.slice(0,4)} aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        {champ.winrateTotal}
                                    </td>
                                    <td style={{padding: '0 15px'}}>
                                        <div className="progress" style={{height: '3px'}}>
                                            <div className="progress-bar" role="progressbar" style={{width: champ.pickRate}} aria-valuenow={champ.pickRate.slice(0,4)} aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        {champ.pickRate}
                                    </td>
                                    <td style={{background:'#282830'}}>{ (champ.banRate) ? (champ.banRate) : 'N/A'}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
  );
}


