import axios from 'axios';
// Create base axios client mapping server ports
const api = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json',
  },
});
// Response interceptor to intercept standard ApiResponse<T> wrapper
api.interceptors.response.use(
  (response) => {
    // If the backend has wrapped response inside ApiResponse
    if (response.data && response.data.success !== undefined) {
      if (response.data.success) {
        return response.data.data;
      }
      return Promise.reject(response.data);
    }
    return response.data;
  },
  (error) => {
    // Standardize error formats for forms and components
    const errorData = error.response?.data || {
      success: false,
      message: 'Network connection error. Please try again.',
      errorCode: 'NETWORK_ERROR',
      details: []
    };
    return Promise.reject(errorData);
  }
);
export default api;