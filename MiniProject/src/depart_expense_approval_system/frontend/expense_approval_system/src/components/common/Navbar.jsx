import React from 'react';
import { useRole } from '../../context/RoleContext';
import { User, Shield, RefreshCw } from 'lucide-react';
const Navbar = () => {
  const { role, toggleRole, isManager } = useRole();
  return (
    <nav className="glass-nav px-6 py-4 flex items-center justify-between shadow-sm">
      <div className="flex items-center space-x-3">
        <h1 className="text-xl font-bold bg-gradient-to-r from-brand-600 to-brand-800 bg-clip-text text-transparent">
          ExpenseFlow
        </h1>
        <span className="text-slate-300">|</span>
        <p className="text-sm text-slate-500 font-medium hidden md:block">
          Enterprise Financial Controls
        </p>
      </div>
      <div className="flex items-center space-x-4">
        {/* Role status badge */}
        <div className={`flex items-center space-x-2 px-3 py-1.5 rounded-full text-xs font-semibold ${
          isManager() 
            ? 'bg-purple-50 text-purple-700 border border-purple-100' 
            : 'bg-brand-50 text-brand-700 border border-brand-100'
        }`}>
          {isManager() ? <Shield className="w-3.5 h-3.5" /> : <User className="w-3.5 h-3.5" />}
          <span>{isManager() ? 'Finance Manager' : 'Employee Portal'}</span>
        </div>
        {/* Role toggle button */}
        <button
          onClick={toggleRole}
          className="flex items-center space-x-1.5 px-3 py-1.5 rounded-lg border border-slate-200 text-xs font-medium text-slate-600 bg-white hover:bg-slate-50 transition-colors shadow-sm"
        >
          <RefreshCw className="w-3.5 h-3.5 text-slate-400" />
          <span>Switch Role</span>
        </button>
      </div>
    </nav>
  );
};
export default Navbar;