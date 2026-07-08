import React, { createContext, useContext, useState, useEffect } from 'react';
import { ROLES, DEFAULT_EMPLOYEE_NAME } from '../utils/constants';

const RoleContext = createContext();

const STORAGE_KEY = 'expenseflow_role';

export const RoleProvider = ({ children }) => {
  const [role, setRole] = useState(() => {
    const saved = localStorage.getItem(STORAGE_KEY);
    return saved === ROLES.MANAGER ? ROLES.MANAGER : ROLES.EMPLOYEE;
  });

  const [employeeName] = useState(DEFAULT_EMPLOYEE_NAME);

  useEffect(() => {
    localStorage.setItem(STORAGE_KEY, role);
  }, [role]);

  const isManager = () => role === ROLES.MANAGER;
  const isEmployee = () => role === ROLES.EMPLOYEE;

  const toggleRole = () => {
    setRole((prev) => (prev === ROLES.EMPLOYEE ? ROLES.MANAGER : ROLES.EMPLOYEE));
  };

  return (
    <RoleContext.Provider value={{ role, setRole, employeeName, isManager, isEmployee, toggleRole }}>
      {children}
    </RoleContext.Provider>
  );
};

export const useRole = () => {
  const context = useContext(RoleContext);
  if (!context) {
    throw new Error('useRole must be used within a RoleProvider');
  }
  return context;
};
