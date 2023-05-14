import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ChampionPage } from './pages/ChampionPage';
import { SideBar } from './components/SideBar';
import { AllChampionPage } from './pages/AllChampionPage';
import { MainPlayerTable } from './pages/MainPlayerTable';
import { PlayInPlayerTable } from './pages/PlayInPlayerTable';
import { PlayerPage } from './pages/PlayerPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/:year/champion/:championName" element={<ChampionPage />}/>
          <Route path="/:year/:playerType" element={<MainPlayerTable />}/>
          <Route path="/:year/:playerType/:playerName" element={<PlayerPage />}/>
          {/* <Route path="/:year/mainPlayer" element={<MainPlayerTable />}/>
          <Route path="/:year/playInPlayer" element={<PlayInPlayerTable />}/> */}
          <Route path="/:year/champion" element={<AllChampionPage />}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
