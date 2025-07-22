import { useState } from 'react';

export default function SocietyRegisterPage() {
  const [formData, setFormData] = useState({
    societyName: '',
    address: '',
    city: '',
    state: '',
    country: '',
    postalCode: '',
    contactPerson: '',
    contactEmail: '',
    contactPhone: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Here, you can send the data to the backend
    console.log('Society Registered:', formData);
  };

  const formContainer = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop: '50px',
    color: '#333',
  };

  const formStyle = {
    display: 'flex',
    flexDirection: 'column',
    gap: '15px',
    backgroundColor: 'rgba(255, 255, 255, 0.9)',
    padding: '30px',
    borderRadius: '10px',
    boxShadow: '0 4px 10px rgba(0,0,0,0.2)',
    width: '400px',
  };

  const inputStyle = {
    padding: '10px',
    borderRadius: '5px',
    border: '1px solid #ccc',
  };

  const buttonStyle = {
    padding: '10px',
    backgroundColor: '#007BFF',
    color: '#fff',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  };

  return (
    <div style={formContainer}>
      <h2>Register a Society</h2>
      <form style={formStyle} onSubmit={handleSubmit}>
        <input style={inputStyle} name="societyName" placeholder="Society Name" value={formData.societyName} onChange={handleChange} required />
        <input style={inputStyle} name="address" placeholder="Address" value={formData.address} onChange={handleChange} required />
        <input style={inputStyle} name="city" placeholder="City" value={formData.city} onChange={handleChange} required />
        <input style={inputStyle} name="state" placeholder="State" value={formData.state} onChange={handleChange} required />
        <input style={inputStyle} name="country" placeholder="Country" value={formData.country} onChange={handleChange} required />
        <input style={inputStyle} name="postalCode" placeholder="Postal Code" value={formData.postalCode} onChange={handleChange} required />
        <input style={inputStyle} name="contactPerson" placeholder="Contact Person Name" value={formData.contactPerson} onChange={handleChange} required />
        <input style={inputStyle} type="email" name="contactEmail" placeholder="Contact Email" value={formData.contactEmail} onChange={handleChange} required />
        <input style={inputStyle} name="contactPhone" placeholder="Contact Phone" value={formData.contactPhone} onChange={handleChange} required />
        <button type="submit" style={buttonStyle}>Register Society</button>
      </form>
    </div>
  );
}
