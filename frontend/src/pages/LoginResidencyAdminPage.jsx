import React from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
import './LoginResidencyAdminPage.css';

const LoginResidencyAdminPage = () => {
  const { register, handleSubmit, formState: { errors } } = useForm();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    try {
      const res = await axios.post('http://localhost:8080/api/login-admin', data);
      Swal.fire("Login Success", "Welcome Residency Admin!", "success").then(() => {
        localStorage.setItem("residencyAdmin", JSON.stringify(res.data));
        navigate('/residency-admin-dashboard');
      });
    } catch (err) {
      Swal.fire("Login Failed", err.response?.data || "Invalid credentials", "error");
    }
  };

  return (
    <div className="login-admin-container">
      <h2 align="center">Residency Admin Login</h2>
      <form onSubmit={handleSubmit(onSubmit)} className="login-admin-form">
        <div>
          <label>Email</label>
          <input type="email" {...register("email", { required: true })} />
          {errors.email && <span>Email is required</span>}
        </div>
        <div>
          <label>Password</label>
          <input type="password" {...register("password", { required: true })} />
          {errors.password && <span>Password is required</span>}
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default LoginResidencyAdminPage;
