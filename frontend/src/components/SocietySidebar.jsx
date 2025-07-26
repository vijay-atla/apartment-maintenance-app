import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import './SocietySidebar.css';

const Sidebar = () => {
  const location = useLocation();

  const isActive = (path) => location.pathname.startsWith(path);

  return (
    <div className="sidebar">
      <div className="sidebar-header">
        🏘️ <span>Admin Panel</span>
      </div>
      <nav className="sidebar-nav">
        <Link to="/admin-dashboard" className={isActive('/admin-dashboard') ? 'active' : ''}>
          🏠 Dashboard
        </Link>
        <Link to="/residents" className={isActive('/residents') ? 'active' : ''}>
          👥 Residents
        </Link>
        <Link to="/notices" className={isActive('/notices') ? 'active' : ''}>
          📢 Notices
        </Link>
        <Link to="/maintenance" className={isActive('/maintenance') ? 'active' : ''}>
          💸 Maintenance
        </Link>
        <Link to="/logout" className="logout">
          🚪 Logout
        </Link>
      </nav>
    </div>
  );
};

export default Sidebar;
