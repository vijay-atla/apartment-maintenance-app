import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios'
import './RegisterAdminPage.css';
import Swal from 'sweetalert2';
import { api } from "../apiClient";


const RegisterAdminPage = () => {
  const { register, handleSubmit, watch, reset, formState: { errors } } = useForm();
  const [serverMsg, setServerMsg] = useState('');
  const password = watch('password');

  const onSubmit = async (data) => {
    try {
  const payload = {
    firstName: data.firstName,
    lastName: data.lastName,
    email: data.email,
    phone: data.phone,
    password: data.password
  };

  const response = await api.post("/api/register-admin", payload);

  Swal.fire({
    icon: 'success',
    title: 'Registered Successfully!',
    text: 'You can now proceed to login.',
    confirmButtonColor: '#3085d6'
  });

  reset();
} catch (error) {
  console.error(error);
  Swal.fire({
    icon: 'error',
    title: 'Oops...',
    text: error.response?.data?.message || 'Registration failed.',
    confirmButtonColor: '#d33'
  });
}

  }



  return (
    <div className="register-container">
      <form className="register-form" onSubmit={handleSubmit(onSubmit)}>
        <h2>Register as Society Admin</h2>

        <label>First Name</label>
        <input {...register('firstName', { required: 'First Name is required' })} />
        {errors.firstName && <span className="error">{errors.firstName.message}</span>}

        <label>Last Name</label>
        <input {...register('lastName', { required: 'Last Name is required' })} />
        {errors.lastName && <span className="error">{errors.lastName.message}</span>}

        <label>Email</label>
        <input {...register('email', { required: 'Email is required', pattern: /^\S+@\S+$/i })} />
        {errors.email && <span className="error">Valid email is required</span>}

        <label>Phone</label>
        <input {...register('phone', { required: 'Phone is required', pattern: /^[0-9]{10}$/ })} />
        {errors.phone && <span className="error">Valid 10-digit phone required</span>}

        <label>Password</label>
        <input type="password" {...register('password', { required: 'Password is required', minLength: 6 })} />
        {errors.password && <span className="error">{errors.password.message}</span>}

        <label>Confirm Password</label>
        <input type="password" {...register('confirmPassword', {
          required: 'Confirm Password is required',
          validate: value => value === password || 'Passwords do not match'
        })} />
        {errors.confirmPassword && <span className="error">{errors.confirmPassword.message}</span>}

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default RegisterAdminPage;
