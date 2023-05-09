import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ChampionPage } from './pages/ChampionPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/champion/:championName" element={<ChampionPage />}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
