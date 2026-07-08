import React from 'react';
import { useRole } from '../../context/RoleContext';
import { AlertTriangle } from 'lucide-react';

const ProtectedRoute = ({ children, allowedRoles }) => {
  const { role } = useRole();

  if (!allowedRoles.includes(role)) {
    return (
      <div className="flex flex-col items-center justify-center py-12 px-4 bg-white rounded-2xl border border-slate-100 shadow-premium max-w-lg mx-auto">
        <AlertTriangle className="w-12 h-12 text-yellow-500 mb-4" />
        <h3 className="text-lg font-bold text-slate-800">Access Restricted</h3>
        <p className="text-sm text-slate-500 text-center mt-2">
          You do not have permission to view this page. Switch your portal role using the header toggle.
        </p>
      </div>
    );
  }

  return children;
};

export default ProtectedRoute;
