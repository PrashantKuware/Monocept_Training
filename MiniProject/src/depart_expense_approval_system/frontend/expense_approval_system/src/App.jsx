import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { RoleProvider } from './context/RoleContext';
import AppRoutes from './routes';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './index.css';
function App() {
  return (
    <BrowserRouter>
      <RoleProvider>
        <AppRoutes />
        <ToastContainer
          position="top-right"
          autoClose={4000}
          hideProgressBar={false}
          newestOnTop
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
          theme="light"
        />
      </RoleProvider>
    </BrowserRouter>
  );
}
export default App;