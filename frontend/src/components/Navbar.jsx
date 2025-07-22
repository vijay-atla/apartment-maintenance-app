import { Link } from 'react-router-dom';

export default function Navbar() {
  const navbarContainerStyle = {
    padding: '5px',
  };

  const navbarStyle = {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '20px 40px',
    backgroundColor: '#282c34',
    color: '#fff',
    boxShadow: '0 2px 4px rgba(0,0,0,0.2)',
    borderRadius: '12px',
  };

  const leftLinksStyle = {
    display: 'flex',
    alignItems: 'center',
    gap: '50px',
    marginLeft: '50px',
  };

  const rightLinksStyle = {
    display: 'flex',
    alignItems: 'center',
    gap: '50px',
    marginRight: '50px',
  };

  const linkStyle = {
    color: '#fff',
    textDecoration: 'none',
    fontSize: '16px',
    transition: 'color 0.3s',
  };

  return (
    <div style={navbarContainerStyle}>
      <nav style={navbarStyle}>
        <div style={leftLinksStyle}>
          <Link to="/" style={linkStyle}>Home</Link>
          <Link to="/about" style={linkStyle}>About</Link>
        </div>
        <div style={rightLinksStyle}>
          <Link to="/login" style={linkStyle}>Login</Link>
          <Link to="/register" style={linkStyle}>Register</Link>
        </div>
      </nav>
    </div>
  );
}
