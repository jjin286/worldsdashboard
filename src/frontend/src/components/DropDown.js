import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

export const DropDown = ({year}) => {
  return (
    <Navbar variant="dark" bg="dark" expand="lg">
      <Container fluid>
        <Navbar.Toggle aria-controls="navbar-dark-example" />
        <Navbar.Collapse id="navbar-dark-example">
          <Nav>
            <NavDropdown
              id="nav-dropdown-dark-example"
              title={year}
              size='lg'
              menuVariant="dark"
            >
              <NavDropdown.Item href={`${window.location.protocol}${window.location.hostname}/${year}/team/mainTeam`}>Main Stage Teams</NavDropdown.Item>
              <NavDropdown.Item href={`${window.location.protocol}${window.location.hostname}/${year}/mainPlayer`}>Main Stage Players</NavDropdown.Item>
              <NavDropdown.Item href={`${window.location.protocol}${window.location.hostname}/${year}/team/playInTeam`}>Play-In Stage Teams</NavDropdown.Item>
              <NavDropdown.Item href={`${window.location.protocol}${window.location.hostname}/${year}/playInPlayer`}>Play-In Stage Players</NavDropdown.Item>
              <NavDropdown.Item href={`${window.location.protocol}${window.location.hostname}/${year}/champion`}>Champions</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

