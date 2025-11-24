

import React from 'react'


import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import landingBg from './assets/home_page_bg.png';

import RegisterLandingPage from './pages/RegisterLandingPage';
import RegisterAdminPage from './pages/RegisterAdminPage';
import SocietyRegisterPage from './pages/SocietyRegisterPage';
import LoginResidencyAdminPage from './pages/LoginResidencyAdminPage';
import ResidencyAdminDashboard from './pages/ResidencyAdminDashboard';
import AddSocietyPage from './pages/AddSocietyPage';
import SocietyDashboard from './pages/SocietyDashboard';

function App() {


  return (
    <div className="app-container">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/register" element={<RegisterLandingPage />} />
          <Route path="/register-admin" element={<RegisterAdminPage />} />
          <Route path="/login-residency-admin" element={<LoginResidencyAdminPage />} />
          <Route path="/residency-admin-dashboard" element={<ResidencyAdminDashboard />} />
          <Route path="/add-society" element={<AddSocietyPage />} />
          <Route path="/society-dashboard/:id" element={<SocietyDashboard />} />

          <Route path="/register/society" element={<SocietyRegisterPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;