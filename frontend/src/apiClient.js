// frontend/src/apiClient.js
import axios from "axios";

// Use Vite env var at build time
const API_BASE = import.meta.env.VITE_API_URL;
// Optional: fallback for local dev if you haven't set the env file yet
const FALLBACK = "http://localhost:8080";

export const api = axios.create({
  baseURL: API_BASE || FALLBACK,
  withCredentials: false, // set true only if you actually use cookies/auth
});
