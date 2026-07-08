import React from 'react';
import { NavLink } from 'react-router-dom';
import { useRole } from '../../context/RoleContext';
import { Home, FilePlus, CheckSquare, DollarSign, BarChart3, Lock } from 'lucide-react';
const Sidebar = () => {
  const { role, employeeName } = useRole();
  const links = [
    { to: '/', label: 'Dashboard', icon: Home, roles: ['EMPLOYEE', 'MANAGER'] },
    { to: '/claims', label: 'My Expenses', icon: FilePlus, roles: ['EMPLOYEE'] },
    { to: '/claims', label: 'Claims Ledger', icon: FilePlus, roles: ['MANAGER'] },
    { to: '/submit-claim', label: 'New Expense Claim', icon: FilePlus, roles: ['EMPLOYEE'] },
    { to: '/review-claims', label: 'Review Claims', icon: CheckSquare, roles: ['MANAGER'] },
    { to: '/budgets', label: 'Manage Budgets', icon: DollarSign, roles: ['MANAGER'] },
    { to: '/summary', label: 'Finance Summary', icon: BarChart3, roles: ['MANAGER'] },
  ];
  return (
    <aside className="w-64 bg-slate-950 text-slate-300 min-h-screen border-r border-slate-900 flex flex-col justify-between">
      <div className="p-6">
        <div className="flex items-center space-x-3 mb-8">
          <div className="w-8 h-8 rounded-lg bg-brand-500 flex items-center justify-center font-bold text-white shadow-premium">
            EF
          </div>
          <div>
            <h2 className="text-white font-bold leading-tight">ExpenseFlow</h2>
            <span className="text-[10px] text-slate-500 tracking-wider uppercase font-semibold">v1.0.0</span>
          </div>
        </div>
        <nav className="space-y-1.5">
          {links.map((link) => {
            const hasAccess = link.roles.includes(role);
            const Icon = link.icon;
            return (
              <NavLink
                key={`${link.to}-${link.label}`}
                to={link.to}
                className={({ isActive }) => 
                  `flex items-center justify-between px-4 py-2.5 rounded-xl text-sm font-medium transition-all duration-200 ${
                    isActive 
                      ? 'bg-brand-600 text-white shadow-premium' 
                      : 'text-slate-400 hover:bg-slate-900 hover:text-white'
                  } ${!hasAccess ? 'opacity-50 cursor-not-allowed pointer-events-none' : ''}`
                }
              >
                <div className="flex items-center space-x-3">
                  <Icon className="w-4 h-4" />
                  <span>{link.label}</span>
                </div>
                {!hasAccess && <Lock className="w-3.5 h-3.5 text-slate-600" />}
              </NavLink>
            );
          })}
        </nav>
      </div>
      <div className="p-6 border-t border-slate-900">
        <div className="flex items-center space-x-3">
          <div className="w-9 h-9 rounded-full bg-slate-800 flex items-center justify-center text-xs font-bold text-brand-400 border border-slate-700">
            JD
          </div>
          <div>
            <p className="text-xs font-semibold text-white">{employeeName}</p>
            <p className="text-[10px] text-slate-500">{role === 'MANAGER' ? 'Finance Manager' : 'Employee Portal'}</p>
          </div>
        </div>
      </div>
    </aside>
  );
};
export default Sidebar;