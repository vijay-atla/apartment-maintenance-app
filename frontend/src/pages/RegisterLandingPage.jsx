import { useNavigate } from 'react-router-dom';

export default function RegisterLandingPage() {
  const navigate = useNavigate();

  const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop: '50px',
    color: '#333',
  };

  const tilesContainer = {
    display: 'flex',
    gap: '30px',
    marginTop: '40px',
    flexWrap: 'wrap',
    justifyContent: 'center',
  };

  const tileStyle = {
    width: '250px',
    height: '200px',
    backgroundColor: '#007BFF',
    color: '#fff',
    borderRadius: '12px',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    cursor: 'pointer',
    fontSize: '18px',
    boxShadow: '0 4px 10px rgba(0,0,0,0.3)',
    transition: 'transform 0.3s',
  };

  const iconStyle = {
    fontSize: '75px',
    marginBottom: '10px',
  };

  const handleTileClick = (path) => {
    navigate(path);
  };

  return (
    <div style={containerStyle}>
      <h2>Choose Registration Type</h2>
      <div style={tilesContainer}>
        <div
          style={tileStyle}
          onClick={() => handleTileClick('/register-admin')}
          onMouseOver={(e) => e.currentTarget.style.transform = 'scale(1.05)'}
          onMouseOut={(e) => e.currentTarget.style.transform = 'scale(1)'}
        >
          <div style={iconStyle}>🏢</div>
          Register a Society
        </div>
        <div
          style={tileStyle}
          onClick={() => handleTileClick('/register/resident')}
          onMouseOver={(e) => e.currentTarget.style.transform = 'scale(1.05)'}
          onMouseOut={(e) => e.currentTarget.style.transform = 'scale(1)'}
        >
          <div style={iconStyle}>👤</div>
          Resident Registration
        </div>
      </div>
    </div>
  );
}
