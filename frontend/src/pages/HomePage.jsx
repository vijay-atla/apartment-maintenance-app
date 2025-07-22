
import home_page_bg from '../assets/home_page_bg.png'


export default function HomePage() {
  const containerStyle = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    height: '100vh',
    // backgroundImage: `url(${home_page_bg})`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    textAlign: 'center',
    color: '#333',
    padding: '20px',
  };

  
  const leftContentStyle = {

    alignSelf: 'flex-start',
    marginTop: '75px',
    marginLeft: '-150px',


    maxWidth: '750px',
    textShadow: '2px 2px 4px rgba(0, 0, 0, 0.5)',
  };

  const headingStyle = {
    fontSize: '2.8rem',
    marginBottom: '20px',
  };

  const paragraphStyle = {
    fontSize: '1.2rem',
    lineHeight: '1.5',
  };


  
  const rightButtonContainer = {
    alignSelf: 'flex-start',
    marginTop: '125px',
    marginLeft: '200px',
  };


  const buttonStyle = {
    padding: '18px 72px',
    backgroundColor: '#007BFF',
    color: '#fff',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    boxShadow: '0 4px 6px rgba(0,0,0,0.3)',
  };

  return (
    <div style={containerStyle}>
      <div style={leftContentStyle}>
        <h1 style={headingStyle}>🏢 Welcome to Apartment Maintenance System</h1>
        <p style={paragraphStyle}>
          Easily manage maintenance requests, payments, and stay connected with your community.
        </p>
      </div>
      <div style={rightButtonContainer}>
        <button style={buttonStyle} onClick={() => alert('Navigate to Register/Login')}>
          Get Started
        </button>
      </div>
    </div>
  );
}