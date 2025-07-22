import React from 'react';
import { useForm } from 'react-hook-form';
import './RegisterAdminPage.css';

const RegisterAdminPage = () => {
  const { register, handleSubmit, watch, formState: { errors } } = useForm();
  const password = watch('password');

  const onSubmit = (data) => {
    console.log('Register Admin Data:', data);
  };

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
