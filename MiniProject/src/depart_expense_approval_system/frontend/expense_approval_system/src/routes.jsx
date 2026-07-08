import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Layout from './components/common/Layout';
import ProtectedRoute from './components/common/ProtectedRoute';
import { ROLES } from './utils/constants';
import DashboardPage from './pages/DashboardPage';
import ClaimSubmissionPage from './pages/ClaimSubmissionPage';
import ClaimListPage from './pages/ClaimListPage';
import ClaimReviewPage from './pages/ClaimReviewPage';
import BudgetPage from './pages/BudgetPage';
import SummaryPage from './pages/SummaryPage';

const AppRoutes = () => {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<DashboardPage />} />
        <Route path="/claims" element={<ClaimListPage />} />
        <Route
          path="/submit-claim"
          element={
            <ProtectedRoute allowedRoles={[ROLES.EMPLOYEE]}>
              <ClaimSubmissionPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/review-claims"
          element={
            <ProtectedRoute allowedRoles={[ROLES.MANAGER]}>
              <ClaimReviewPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/budgets"
          element={
            <ProtectedRoute allowedRoles={[ROLES.MANAGER]}>
              <BudgetPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/summary"
          element={
            <ProtectedRoute allowedRoles={[ROLES.MANAGER]}>
              <SummaryPage />
            </ProtectedRoute>
          }
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Route>
    </Routes>
  );
};

export default AppRoutes;
