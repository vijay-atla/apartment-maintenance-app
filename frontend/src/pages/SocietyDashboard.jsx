import React, { useEffect, useState } from 'react';
import { useParams, useLocation } from 'react-router-dom';
import './SocietyDashboard.css';
import Sidebar from '../components/SocietySidebar';
import axios from 'axios';
import Swal from 'sweetalert2';

const SocietyDashboard = () => {
  const { id: societyId } = useParams();
  const location = useLocation();
  const society = location.state?.society || null;

  const [buildings, setBuildings] = useState([]);
  const [selectedBuilding, setSelectedBuilding] = useState(null);
  const [flats, setFlats] = useState([]);
  const [showBuildingModal, setShowBuildingModal] = useState(false);
  const [showFlatModal, setShowFlatModal] = useState(false);
  const [buildingName, setBuildingName] = useState('');
  const [flatNumber, setFlatNumber] = useState('');
  const [floorNumber, setFloorNumber] = useState('');

  useEffect(() => {
    if (societyId) fetchBuildings();
  }, [societyId]);

  const fetchBuildings = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/api/buildings/${societyId}`);
      setBuildings(res.data);
    } catch (err) {
      console.error('Error fetching buildings', err);
    }
  };

  const fetchFlats = async (buildingId) => {
    try {
      const res = await axios.get(`http://localhost:8080/api/flats/${buildingId}`);
      setFlats(res.data);
    } catch (err) {
      console.error('Error fetching flats', err);
    }
  };

  const handleSelectBuilding = (building) => {
    setSelectedBuilding(building);
    fetchFlats(building.id);
  };

  const handleAddBuilding = async () => {
    try {
      await axios.post('http://localhost:8080/api/buildings', {
        name: buildingName,
        societyId: societyId,
      });
      Swal.fire('Success', 'Building added!', 'success');
      setBuildingName('');
      setShowBuildingModal(false);
      fetchBuildings();
    } catch (err) {
      Swal.fire('Error', 'Could not add building', 'error');
    }
  };

  const handleAddFlat = async () => {
    try {
      await axios.post('http://localhost:8080/api/flats', {
        flatNumber,
        floorNumber,
        buildingId: selectedBuilding.id,
      });
      Swal.fire('Success', 'Flat added!', 'success');
      setFlatNumber('');
      setFloorNumber('');
      setShowFlatModal(false);
      fetchFlats(selectedBuilding.id);
    } catch (err) {
      Swal.fire('Error', 'Could not add flat', 'error');
    }
  };

  return (
    <div className="society-dashboard">
      <Sidebar />
      <div className="dashboard-content">
        <h2>🏢 Manage {society?.name || 'Society'} Buildings & Flats</h2>

        <button className="add-btn" onClick={() => setShowBuildingModal(true)}>
          + Add Building
        </button>

        <div className="building-list">
          {buildings.map((b) => (
            <div
              key={b.id}
              className={`building-card ${selectedBuilding?.id === b.id ? 'selected' : ''}`}
              onClick={() => handleSelectBuilding(b)}
            >
              🏙️ {b.name}
            </div>
          ))}
        </div>

        {selectedBuilding && (
          <div className="flat-section">
            <h3>Flats in {selectedBuilding.name}</h3>
            <button className="add-btn" onClick={() => setShowFlatModal(true)}>
              + Add Flat
            </button>
            <div className="flat-list">
              {flats.map((f) => (
                <div key={f.id} className="flat-card">
                  🏠 Flat {f.flatNumber} - Floor {f.floorNumber}
                </div>
              ))}
            </div>
          </div>
        )}

        {/* Add Building Modal */}
        {showBuildingModal && (
          <div className="modal">
            <div className="modal-content">
              <h3>Add Building</h3>
              <input
                type="text"
                placeholder="Building Name"
                value={buildingName}
                onChange={(e) => setBuildingName(e.target.value)}
              />
              <div className="modal-buttons">
                <button onClick={handleAddBuilding}>Add</button>
                <button onClick={() => setShowBuildingModal(false)}>Cancel</button>
              </div>
            </div>
          </div>
        )}

        {/* Add Flat Modal */}
        {showFlatModal && (
          <div className="modal">
            <div className="modal-content">
              <h3>Add Flat</h3>
              <input
                type="text"
                placeholder="Flat Number"
                value={flatNumber}
                onChange={(e) => setFlatNumber(e.target.value)}
              />
              <input
                type="number"
                placeholder="Floor Number"
                value={floorNumber}
                onChange={(e) => setFloorNumber(e.target.value)}
              />
              <div className="modal-buttons">
                <button onClick={handleAddFlat}>Add</button>
                <button onClick={() => setShowFlatModal(false)}>Cancel</button>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default SocietyDashboard;