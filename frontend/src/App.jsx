

import React from 'react'


import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import landingBg from './assets/home_page_bg.png';

import RegisterLandingPage from './pages/RegisterLandingPage';
import RegisterAdminPage from './pages/RegisterAdminPage';
import SocietyRegisterPage from './pages/SocietyRegisterPage';


function App() {

  const appStyle = {
    minHeight: '100vh',
    backgroundImage: `url(${landingBg})`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
  };


  return (
    <div style={appStyle}>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/register" element={<RegisterLandingPage />} />
          <Route path="/register-admin" element={<RegisterAdminPage />} />
          <Route path="/register/society" element={<SocietyRegisterPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;