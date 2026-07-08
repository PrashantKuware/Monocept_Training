import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from './Navbar';
import Sidebar from './Sidebar';
const Layout = () => {
  return (
    <div className="flex min-h-screen bg-slate-50">
      {/* Sidebar - static on desktop */}
      <Sidebar />
      {/* Main content pane */}
      <div className="flex-1 flex flex-col min-h-screen overflow-x-hidden">
        {/* Glass Navbar */}
        <Navbar />
        {/* Content Body */}
        <main className="flex-1 p-6 md:p-8 max-w-7xl w-full mx-auto">
          <Outlet />
        </main>
      </div>
    </div>
  );
};
export default Layout;