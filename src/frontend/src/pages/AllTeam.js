import { React, useEffect , useState } from 'react';
import { useParams } from 'react-router-dom';
import { WorldsNavbar } from '../components/WorldsNavbar';
import { SideBar } from '../components/SideBar';
import { Pagination } from '../components/Pagination';


export const AllTeam = () => {
    const [teams, setTeams] = useState([]);
    const { year, teamType } = useParams();
    // Sorting
    const [sortBy, setSortBy] = useState({field: "team", ascending: true});
    const [currentPage, setCurrentPage] = useState(1);
    const [perPage] = useState(20);
    const indexLast = currentPage * perPage;
    const indexFirst = indexLast - perPage;
    const currentRows = teams.slice(indexFirst, indexLast);
    const numPage = Math.ceil(teams.length / perPage);
    
    useEffect(
        () => {
            const fetchTeams = async () => {
                const response = await fetch(`http://localhost:8080/${year}/${teamType}`);
                const data = await response.json();
                setTeams(data);
                console.log(teams);
            }

            fetchTeams();
        }, [teamType, teams, year]
    );

    useEffect(
        () => {
            const currentTeam = [...teams];
        
            const sortedTeam = currentTeam.sort((a, b) => {
                if(sortBy.field.slice(0 , -1) === '%') {
                    return parseFloat(a[sortBy.field].slice(0, -1)) - parseFloat(b[sortBy.field].slice(0, -1));
                } else if ( !isNaN(a[sortBy.field])) {
                    return parseInt(a[sortBy.field]) - parseInt(b[sortBy.field]);
                } else {
                    return a[sortBy.field].localeCompare(b[sortBy.field]);
                }
            });
        
            setTeams( 
                sortBy.ascending ? sortedTeam : sortedTeam.reverse()
            );
        }, [teams, sortBy]
    );

    const onClickSort = (key, ascending) => {
        setSortBy({ field: key, ascending: ascending });
    };

    return (
        <div className="AllTeam">
            <div className='row g-0'>
                <div className='col-2'>
                    <SideBar year={year}/>
                </div>
                <div className='col-10'>
                    <WorldsNavbar />
                    <h1 style={{ color: 'white', padding: '0 0 0 50px'}}>{year} { teamType === "mainTeam" ? "Main Stage Teams" : "Play-In Stage Teams"}</h1>
                    <div className="championTable p-5">
                        <table className='table-scroll'>
                            <thead>
                                <tr>
                                    <th style={{width:'5%'}} onClick={() => onClickSort("team", !sortBy.ascending)}>Name</th>
                                    <th onClick={() => onClickSort("gamesPlayed", !sortBy.ascending)}>GP</th>
                                    <th onClick={() => onClickSort("wins", !sortBy.ascending)}>Wins</th>
                                    <th onClick={() => onClickSort("loses", !sortBy.ascending)}>Loses</th>
                                    <th onClick={() => onClickSort("averageGameDuration", !sortBy.ascending)}>AVG GD</th>
                                    <th onClick={() => onClickSort("kills", !sortBy.ascending)}>Kills</th>
                                    <th onClick={() => onClickSort("deaths", !sortBy.ascending)}>Deaths</th>
                                    <th onClick={() => onClickSort("kd", !sortBy.ascending)}>KD</th>
                                    <th onClick={() => onClickSort("combinedKillsPerMinute", !sortBy.ascending)}>CKM</th>
                                    <th onClick={() => onClickSort("goldPercentRating", !sortBy.ascending)}>GR</th>
                                    <th onClick={() => onClickSort("goldSpentDifference", !sortBy.ascending)}>GSD</th>
                                    <th onClick={() => onClickSort("earlyGameRating", !sortBy.ascending)}>EGR</th>
                                    <th onClick={() => onClickSort("midLateRating", !sortBy.ascending)}>MLR</th>
                                    <th onClick={() => onClickSort("goldDiff15", !sortBy.ascending)}>GD@15</th>
                                    <th onClick={() => onClickSort("firstBloodRate", !sortBy.ascending)}>FB</th>
                                    <th onClick={() => onClickSort("firstTowerRate", !sortBy.ascending)}>FT</th>
                                    <th onClick={() => onClickSort("firstToThreeTowersRate", !sortBy.ascending)}>F3T</th>
                                    <th onClick={() => onClickSort("turrentPlatesDestroyed", !sortBy.ascending)}>TP</th>
                                    <th onClick={() => onClickSort("riftHeraldRate", !sortBy.ascending)}>RHR</th>
                                    <th onClick={() => onClickSort("firstDragonRate", !sortBy.ascending)}>FDR</th>
                                    <th onClick={() => onClickSort("dragonControlRate", !sortBy.ascending)}>DCR</th>
                                    <th onClick={() => onClickSort("elderDragonRate", !sortBy.ascending)}>EDR</th>
                                    <th onClick={() => onClickSort("firstBaronRate", !sortBy.ascending)}>FBR</th>
                                    <th onClick={() => onClickSort("baronControlRate", !sortBy.ascending)}>BCR</th>
                                    <th onClick={() => onClickSort("laneControl", !sortBy.ascending)}>LC</th>
                                    <th onClick={() => onClickSort("jungleControl", !sortBy.ascending)}>JC</th>
                                    <th onClick={() => onClickSort("wardsPerMinute", !sortBy.ascending)}>WPM</th>
                                    <th onClick={() => onClickSort("controlWardsPerMinute", !sortBy.ascending)}>CWPM</th>
                                    <th onClick={() => onClickSort("wardsClearedPerMinute", !sortBy.ascending)}>WCPM</th>
                                </tr>
                            </thead>
                            <tbody>
                                {currentRows.map((teams) => (
                                    <tr>
                                        <td>
                                            {/* <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={"http://localhost:3000/" + year + "/champion/" + champ.champion}> */}
                                            <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={`http://localhost:3000/${year}/team/${teamType}/${teams.team}`}>
                                                <img src={`/teamLogos/${teams.team}.png`} width="32" height="32" alt=""/>
                                                {teams.team}
                                            </a>
                                        </td>
                                        <td>{teams.gamesPlayed}</td>
                                        <td>{teams.wins}</td>
                                        <td>{teams.loses}</td>
                                        <td>{teams.averageGameDuration}</td>
                                        <td>{teams.kills}</td>
                                        <td>{teams.deaths}</td>
                                        <td>{teams.kd}</td>
                                        <td>{teams.combinedKillsPerMinute}</td>
                                        <td>{teams.goldPercentRating}</td>
                                        <td>{teams.goldSpentDifference}</td>
                                        <td>{teams.earlyGameRating}</td>
                                        <td>{teams.midLateRating}</td>
                                        <td>{teams.goldDiff15}</td>
                                        <td>{teams.firstBloodRate}</td>
                                        <td>{teams.firstTowerRate}</td>
                                        <td>{teams.firstToThreeTowersRate}</td>
                                        <td>{teams.turrentPlatesDestroyed}</td>
                                        <td>{teams.riftHeraldRate}</td>
                                        <td>{teams.firstDragonRate}</td>
                                        <td>{teams.dragonControlRate}</td>
                                        <td>{teams.elderDragonRate}</td>
                                        <td>{teams.firstBaronRate}</td>
                                        <td>{teams.baronControlRate}</td>
                                        <td>{teams.laneControl}</td>
                                        <td>{teams.jungleControl}</td>
                                        <td>{teams.wardsPerMinute}</td>
                                        <td>{teams.controlWardsPerMinute}</td>
                                        <td>{teams.wardsClearedPerMinute}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                        <Pagination numPages = {numPage} currentPage = {currentPage} setCurrentPage={setCurrentPage}/>
                    </div>
                </div>
            </div>
        </div>
    );
}