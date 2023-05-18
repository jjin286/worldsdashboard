import { React, useEffect , useState } from 'react';
import { useParams } from 'react-router-dom';
import { WorldsNavbar } from '../components/WorldsNavbar';
import { SideBar } from '../components/SideBar';
import { Pagination } from '../components/Pagination';


export const AllPlayerPage = () => {
    const [players, setPlayers] = useState([]);
    const { year, playerType } = useParams();
    // Sorting
    const [sortBy, setSortBy] = useState({field: "player", ascending: true});
    const [currentPage, setCurrentPage] = useState(1);
    const [perPage] = useState(20);
    const indexLast = currentPage * perPage;
    const indexFirst = indexLast - perPage;
    const currentRows = players.slice(indexFirst, indexLast);
    const numPage = Math.ceil(players.length / perPage);
    
    useEffect(
        () => {
            const fetchPlayers = async () => {
                const response = await fetch(`http://localhost:8080/${year}/${playerType}`);
                const data = await response.json();
                setPlayers(data);
                console.log(players);
            }

            fetchPlayers();
        }, [playerType, players, year]
    );

    useEffect(
        () => {
            const currentPlayer = [...players];
        
            const sortedPlayer = currentPlayer.sort((a, b) => {
                if(sortBy.field.slice(0 , -1) === '%') {
                    return parseFloat(a[sortBy.field].slice(0, -1)) - parseFloat(b[sortBy.field].slice(0, -1));
                } else if ( !isNaN(a[sortBy.field])) {
                    return parseInt(a[sortBy.field]) - parseInt(b[sortBy.field]);
                } else {
                    return a[sortBy.field].localeCompare(b[sortBy.field]);
                }
            });
        
            setPlayers( 
                sortBy.ascending ? sortedPlayer : sortedPlayer.reverse()
            );
        }, [players, sortBy]
    );

    const onClickSort = (key, ascending) => {
        setSortBy({ field: key, ascending: ascending });
    };

    return (
        <div className="PlayerTable">
            <div className='row g-0'>
                <div className='col-2'>
                    <SideBar year={year}/>
                </div>
                <div className='col-10'>
                    <WorldsNavbar />
                    <h1 style={{ color: 'white', padding: '0 0 0 50px'}}>{year} { playerType === "mainPlayer" ? "Main Stage Players" : "Play-In Stage Players"}</h1>
                    <div className="championTable p-5">
                        <table className='table-scroll'>
                            <thead>
                                <tr>
                                    <th onClick={() => onClickSort("player", !sortBy.ascending)}>Name</th>
                                    <th onClick={() => onClickSort("team", !sortBy.ascending)}>Team</th>
                                    <th onClick={() => onClickSort("position", !sortBy.ascending)}>Position</th>
                                    <th onClick={() => onClickSort("goldPerMinute", !sortBy.ascending)}>GP</th>
                                    <th onClick={() => onClickSort("winrate", !sortBy.ascending)}>Win%</th>
                                    <th onClick={() => onClickSort("counterPickrate", !sortBy.ascending)}>CP%</th>
                                    <th onClick={() => onClickSort("kills", !sortBy.ascending)}>Kills</th>
                                    <th onClick={() => onClickSort("deaths", !sortBy.ascending)}>Deaths</th>
                                    <th onClick={() => onClickSort("assists", !sortBy.ascending)}>Assists</th>
                                    <th onClick={() => onClickSort("kda", !sortBy.ascending)}>KDA</th>
                                    <th onClick={() => onClickSort("kp", !sortBy.ascending)}>KP</th>
                                    <th onClick={() => onClickSort("killShare", !sortBy.ascending)}>KS%</th>
                                    <th onClick={() => onClickSort("shareTeamDeaths", !sortBy.ascending)}>STD%</th>
                                    <th onClick={() => onClickSort("firstBloodRate", !sortBy.ascending)}>GD@10</th>
                                    <th onClick={() => onClickSort("goldDiff10", !sortBy.ascending)}>XPD@10</th>
                                    <th onClick={() => onClickSort("xpDiff10", !sortBy.ascending)}>CSD@10</th>
                                    <th onClick={() => onClickSort("csDiff10", !sortBy.ascending)}>CSPM</th>
                                    <th onClick={() => onClickSort("cspm", !sortBy.ascending)}>STD@15</th>
                                    <th onClick={() => onClickSort("shareTeamDeaths15", !sortBy.ascending)}>DPM</th>
                                    <th onClick={() => onClickSort("damagePerMinute", !sortBy.ascending)}>SD%</th>
                                    <th onClick={() => onClickSort("shareDamage", !sortBy.ascending)}>SDMG%</th>
                                    <th onClick={() => onClickSort("shareTeamDamage15", !sortBy.ascending)}>STDMG@15</th>
                                    <th onClick={() => onClickSort("averageGoldPerMinute", !sortBy.ascending)}>AVGGPM</th>
                                    <th onClick={() => onClickSort("goldShare", !sortBy.ascending)}>GS%</th>
                                    <th onClick={() => onClickSort("neutralObjectiveStolen", !sortBy.ascending)}>Neutrals</th>
                                    <th onClick={() => onClickSort("wardsPerMinute", !sortBy.ascending)}>WPM</th>
                                    <th onClick={() => onClickSort("controlWardsPerMinute", !sortBy.ascending)}>CWPM</th>
                                    <th onClick={() => onClickSort("wardsClearedPerMinute", !sortBy.ascending)}>WCPM</th>
                                </tr>
                            </thead>
                            <tbody>
                                {currentRows.map((player) => (
                                    <tr>
                                        <td>
                                            {/* <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={"http://localhost:3000/" + year + "/champion/" + champ.champion}> */}
                                            <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={"http://localhost:3000/" + year + "/" + playerType + "/" + player.player}>
                                                <img src={`/playerImages/${player.player}${year}.png`} width="40" height="30" alt=""/>
                                                {player.player}
                                            </a>
                                        </td>
                                        <td>
                                            {playerType === "mainPlayer" ? 
                                            <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={"http://localhost:3000/" + year + "/team/mainTeam/" + player.team}>
                                                <img src={`/teamLogos/${player.team}.png`} width="32" height="32" alt=""/>
                                                {player.team}
                                            </a>
                                            :
                                            <a className="text-decoration-none" style={{color:'#9E9EB1'}} href={"http://localhost:3000/" + year + "/team/playInTeam/" + player.team}>
                                                <img src={`/teamLogos/${player.team}.png`} width="32" height="32" alt=""/>
                                                {player.team}
                                            </a>}
                                            </td>
                                        <td>{player.position}</td>
                                        <td>{player.goldPerMinute}</td>
                                        <td>{player.winrate}</td>
                                        <td>{player.counterPickrate}</td>
                                        <td>{player.deaths}</td>
                                        <td>{player.assists}</td>
                                        <td>{player.kda}</td>
                                        <td>{player.kp}</td>
                                        <td>{player.killShare}</td>
                                        <td>{player.shareTeamDeaths}</td>
                                        <td>{player.firstBloodRate}</td>
                                        <td>{player.goldDiff10}</td>
                                        <td>{player.xpDiff10}</td>
                                        <td>{player.csDiff10}</td>
                                        <td>{player.cspm}</td>
                                        <td>{player.shareTeamDeaths15}</td>
                                        <td>{player.damagePerMinute}</td>
                                        <td>{player.shareDamage}</td>
                                        <td>{player.shareTeamDamage15}</td>
                                        <td>{player.averageGoldPerMinute}</td>
                                        <td>{player.goldShare}</td>
                                        <td>{player.neutralObjectiveStolen}</td>
                                        <td>{player.wardsPerMinute}</td>
                                        <td>{player.controlWardsPerMinute}</td>
                                        <td>{player.wardsClearedPerMinute}</td>
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