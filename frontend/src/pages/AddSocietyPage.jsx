import React, {useState} from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios';
import { api } from "../apiClient";
import Swal from 'sweetalert2';
import './AddSocietyPage.css';

const AddSocietyPage = () => {
  const { register, handleSubmit, reset, formState: { errors } } = useForm();
  const admin = JSON.parse(localStorage.getItem("residencyAdmin"));

  const [selectedCountry, setSelectedCountry] = useState("");
  const [stateOptions, setStateOptions] = useState([]);


  const countryStateMap = {
    India: [
        "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
        "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala",
        "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
        "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
        "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands",
        "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu", "Delhi", "Jammu and Kashmir",
        "Ladakh", "Lakshadweep", "Puducherry"
    ],
    USA: [
        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
        "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
        "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
        "Wisconsin", "Wyoming"
    ],
    Australia: [
        "New South Wales", "Victoria", "Queensland", "Western Australia", "South Australia",
        "Tasmania", "Australian Capital Territory", "Northern Territory"
    ]
    };


  const onSubmit = async (data) => {

    const societyData = {
      name: data.name,
      type: data.type,
      address: {
        state: data.state,
        district: data.district,
        city: data.city,
        locality: data.locality,
        street: data.street,
        address: data.address,
        pinCode: data.pinCode,
        country: data.country
      },
      adminId: admin.userId  // 👈 send this to backend to map the admin
    };

    try {
      await api.post("/api/societies/add", societyData);
      Swal.fire("Success", "Society added successfully!", "success");
      reset();
    } catch (err) {
      Swal.fire("Error", err.response?.data || "Failed to add society", "error");
    }
  };

  return (
    <div className="add-society-container">
      <h2 className="form-title">Add New Society</h2>
      <form onSubmit={handleSubmit(onSubmit)} className="add-society-form">
        <input placeholder="Society Name" {...register("name", { required: true })} />
        <select {...register("type", { required: true })}>
          <option value="">Select Type</option>
          <option value="SMALL">Small</option>
          <option value="MEDIUM">Medium</option>
          <option value="LARGE">Large</option>
        </select>

        <select
            {...register("country", { required: true })}
            onChange={(e) => {
                const country = e.target.value;
                setSelectedCountry(country);
                setStateOptions(countryStateMap[country] || []);
            }}
            >
            <option value="">Select Country</option>
            {Object.keys(countryStateMap).map((country) => (
                <option key={country} value={country}>{country}</option>
            ))}
            </select>

        <select {...register("state", { required: true })}>
            <option value="">Select State</option>
            {stateOptions.map((state) => (
                <option key={state} value={state}>{state}</option>
            ))}
            </select>

        <input placeholder="District" {...register("district", { required: true })} />
        <input placeholder="City" {...register("city", { required: true })} />
        <input placeholder="Locality" {...register("locality", { required: true })} />
        <input placeholder="Street" {...register("street", { required: true })} />
        <input placeholder="Door No. / Landmark" {...register("address", { required: true })} />
        <input placeholder="Pin Code" {...register("pinCode", { required: true })} />

        <button type="submit">Add Society</button>
      </form>
    </div>
  );
};

export default AddSocietyPage;
