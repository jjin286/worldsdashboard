import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ChampionPage } from './pages/ChampionPage';
import { SideBar } from './components/SideBar';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/champion/:year/:championName" element={<ChampionPage />}/>
          <Route path="" element={<SideBar />}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
