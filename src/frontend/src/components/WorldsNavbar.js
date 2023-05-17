import { React } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export const WorldsNavbar = () => {
  return (
    <Navbar className='navbar container-fluid sticky-top' bg="dark" variant="dark" >
        <Container>
          <Nav className="me-auto">
            <Nav.Link href={`${window.location.href.slice(0, 22)}2020${window.location.href.slice(26)}`}>Worlds 2020</Nav.Link>
            <Nav.Link href={`${window.location.href.slice(0, 22)}2021${window.location.href.slice(26)}`}>Worlds 2021</Nav.Link>
            <Nav.Link href={`${window.location.href.slice(0, 22)}2022${window.location.href.slice(26)}`}>Worlds 2022</Nav.Link>
          </Nav>
        </Container>
    </Navbar>
    
  );
}

// window.location.href returns the href (URL) of the current page
// window.location.hostname returns the domain name of the web host
// window.location.pathname returns the path and filename of the current page
// window.location.protocol returns the web protocol used (http: or https:)