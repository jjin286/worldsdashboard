import { React } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export const WorldsNavbar = () => {
  return (
    <Navbar className='container-fluid sticky-top' bg="dark" variant="dark" >
        <Container>
          <Navbar.Brand href="#home">Worlds Statistics</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Worlds 2020</Nav.Link>
            <Nav.Link href="#features">Worlds 2021</Nav.Link>
            <Nav.Link href="#pricing">Worlds 2022</Nav.Link>
          </Nav>
        </Container>
    </Navbar>
    
  );
}
