import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import '../App.css'

export const SideBar = ({year}) => {
   
    return (
      <div className='container-fluid sticky'>
        <div className='row'>
          <div className='sidebar bg-dark min-vh-100 d-flex justify-content-between flex-column'>
            <div>
              <a href={``} className='text-decoration-none d-flex align-itemcenter text-white ms-3 mt-2'>
                <img style={{marginTop: '5px', marginLeft: '5px'}} src={`/images/Worldslogo.png`} width='28' height='28' alt=""/>
                <span className='ms-1 fs-4'>Worlds Statistics</span>
              </a>
              <hr className="text-secondary" />
              <ul className="nav nav-pills flex-column">
                <li className="nav-item">
                  <a href={`${window.location.protocol}${window.location.hostname}/${year}/team/mainTeam`} className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-people-fill"></i>
                    <span className="ms-2">Main Stage Teams</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href={`${window.location.protocol}${window.location.hostname}/${year}/team/playInTeam`} className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-people"></i>
                    <span className="ms-2">Play-In Stage Teams</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer`} className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-person-fill"></i>
                    <span className="ms-2">Main Stage Players</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer`} className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-person"></i>
                    <span className="ms-2">Play-In Stage Players</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href={`${window.location.protocol}${window.location.hostname}/${year}/champion`} className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-trophy-fill"></i>
                    <span className="ms-2">Champions</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
}