import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';

export default function Navbar() {
  const navigate = useNavigate();

  // Detect logged-in user
  const resident = JSON.parse(localStorage.getItem("resident"));
  const residencyAdmin = JSON.parse(localStorage.getItem("residencyAdmin"));
  const superAdmin = JSON.parse(localStorage.getItem("superAdmin"));

  const currentUser = resident || residencyAdmin || superAdmin;
  const role = resident ? "resident" : residencyAdmin ? "residency-admin" : superAdmin ? "super-admin" : null;

  const handleLogout = () => {
    localStorage.removeItem("resident");
    localStorage.removeItem("residencyAdmin");
    localStorage.removeItem("superAdmin");
    navigate('/');
  };

  return (
    <div className="navbar-container">
      <nav className="navbar">
        <div className="navbar-left">
          <Link to="/" className="nav-link">Home</Link>
          <Link to="/about" className="nav-link">About</Link>
          {currentUser && role === "resident" && <Link to="/resident-dashboard" className="nav-link">Dashboard</Link>}
          {currentUser && role === "residency-admin" && <Link to="/residency-admin-dashboard" className="nav-link">Dashboard</Link>}
          {currentUser && role === "super-admin" && <Link to="/super-admin-dashboard" className="nav-link">Dashboard</Link>}
        </div>

        <div className="navbar-right">
          {!currentUser ? (
            <>
              <li className="nav-item dropdown">
                <div className="nav-link login-hover">Login ▾</div>
                <div className="dropdown-content">
                  <a href="/login-resident">Resident Login</a>
                  <a href="/login-residency-admin">Residency Admin Login</a>
                  <a href="/login-super-admin">Super Admin Login</a>
                </div>
              </li>
              <Link to="/register" className="nav-link">Register</Link>
            </>
          ) : (
            <>
              <span className="nav-link">Hello, {currentUser.fullName?.split(' ')[0]}</span>
              <button className="logout-btn" onClick={handleLogout}>Logout</button>
            </>
          )}
        </div>
      </nav>
    </div>
  );
}
