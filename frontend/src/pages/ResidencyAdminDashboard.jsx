import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { api } from "../apiClient";


import axios from 'axios';
import './ResidencyAdminDashboard.css';

const ResidencyAdminDashboard = () => {
  const admin = JSON.parse(localStorage.getItem("residencyAdmin"));
  const [societies, setSocieties] = useState([]);

  useEffect(() => {
    if (admin?.userId) {
      api.get(`/api/societies/admin/${admin.userId}`)
        .then(res => setSocieties(res.data))
        .catch(err => console.error("Error fetching societies", err));
    }
  }, [admin]);

  return (
    <div className="admin-dashboard-container">
      <h2>Welcome, {admin?.fullName}</h2>
      <h4>Your Societies</h4>
      <Link to="/add-society">
        <button className="add-society-btn">+ Add Society</button>
      </Link>
      <div className="society-cards">
        {societies.length === 0 ? (
          <p>No societies assigned yet.</p>
        ) : (
          societies.map(society => (
            <div key={society.id} className="society-card">
              <h3>{society.name}</h3>
              <p>Type: {society.type}</p>
              <p>Location: {society.address.locality}, {society.address.city}</p>
              <Link
                  to={`/society-dashboard/${society.id}`}
                  state={{ society }} // passing the whole society object optionally
                >
                  <button>Manage Society</button>
                </Link>

            </div>
          ))
        )}
        
      </div>
    </div>
  );
};

export default ResidencyAdminDashboard;
