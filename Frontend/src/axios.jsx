import axios from 'axios';

const API = axios.create({
    baseURL: import.meta.env.VITE_BASE_URL,
});

// ADD THIS LINE
console.log("My API URL is:", import.meta.env.VITE_BASE_URL);

export default API;