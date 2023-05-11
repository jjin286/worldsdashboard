import React from "react";
import { NavLink } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import '../App.css'

export const SideBar = ({year}) => {
   
    return (
      <div className='container-fluid'>
        <div className='row'>
          <div className='sidebar bg-dark min-vh-100 d-flex justify-content-between flex-column'>
            <div>
              <a className='text-decoration-none d-flex align-itemcenter text-white ms-3 mt-2'>
                <span className='ms-1 fs-4'>Worlds {year}</span>
              </a>
              <hr className="text-secondary" />
              <ul className="nav nav-pills flex-column">
                <li className="nav-item">
                  <a href="#" className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-people-fill"></i>
                    <span className="ms-2">Main Stage Teams</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href="#" className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-people"></i>
                    <span className="ms-2">Play-In Stage Teams</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href="#" className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-person-fill"></i>
                    <span className="ms-2">Main Stage Players</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href="#" className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-person"></i>
                    <span className="ms-2">Play-In Stage Players</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a href="#" className="nav-link text-white fs-5" aria-current="page">
                    <i className="bi bi-trophy-fill"></i>
                    <span className="ms-2">Champions</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    //     <div style={{ display: 'flex', height: '100vh', overflow: 'scroll initial'}}>
    //   <CDBSidebar className='sidebar' textColor="#fff" backgroundColor="#333">
    //     <CDBSidebarHeader>
    //       <a href="/" className="text-decoration-none" style={{ color: 'inherit' }}>
    //         <img src={process.env.PUBLIC_URL + 'icons8-league-of-legends-32.png'} />
    //         Sidebar
    //       </a>
    //     </CDBSidebarHeader>

    //     <CDBSidebarContent className="sidebar-content">
    //       <CDBSidebarMenu>
    //         <NavLink exact to="/" activeClassName="activeClicked">
    //           <CDBSidebarMenuItem icon="reddit">Main Stage Teams</CDBSidebarMenuItem>
    //         </NavLink>
    //         <NavLink exact to="/tables" activeClassName="activeClicked">
    //           <CDBSidebarMenuItem icon="table">Main Stage Players</CDBSidebarMenuItem>
    //         </NavLink>
    //         <NavLink exact to="/profile" activeClassName="activeClicked">
    //           <CDBSidebarMenuItem icon="user">Play In Teams</CDBSidebarMenuItem>
    //         </NavLink>
    //         <NavLink exact to="/analytics" activeClassName="activeClicked">
    //           <CDBSidebarMenuItem icon="chart-line">Play In Players</CDBSidebarMenuItem>
    //         </NavLink>
    //         <NavLink exact to="/analytics" activeClassName="activeClicked">
    //           <CDBSidebarMenuItem icon="chart-line">Champions</CDBSidebarMenuItem>
    //         </NavLink>
    //       </CDBSidebarMenu>
    //     </CDBSidebarContent>
    //   </CDBSidebar>
    // </div>
    );
}