import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ChampionPage } from './pages/ChampionPage';
import { AllChampionPage } from './pages/AllChampionPage';
import { AllPlayerPage } from './pages/AllPlayerPage';
import { PlayerPage } from './pages/PlayerPage';
import { TeamPage } from './pages/TeamPage';
import { AllTeam } from './pages/AllTeam';
import { LandingPage } from './pages/LandingPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/:year/champion/:championName" element={<ChampionPage />}/>
          <Route path="/:year/team/:teamType/:teamName" element={<TeamPage />}/>
          <Route path="/:year/team/:teamType" element={<AllTeam />}/>
          <Route path="/:year/:playerType" element={<AllPlayerPage />}/>
          <Route path="/:year/:playerType/:playerName" element={<PlayerPage />}/>
          {/* <Route path="/:year/mainPlayer" element={<MainPlayerTable />}/>
          <Route path="/:year/playInPlayer" element={<PlayInPlayerTable />}/> */}
          <Route path="/:year/champion" element={<AllChampionPage />}/>
          <Route path="" element={<LandingPage />}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
