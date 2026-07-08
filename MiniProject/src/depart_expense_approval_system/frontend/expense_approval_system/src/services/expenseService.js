import api from './api';
export const expenseService = {
  submitClaim: (claimData) => {
    return api.post('/v1/expense-claims', claimData);
  },
  getClaims: (filters = {}) => {
    // Sanitize empty filters to avoid appending undefined variables
    const params = {};
    Object.keys(filters).forEach((key) => {
      if (filters[key] !== undefined && filters[key] !== null && filters[key] !== '') {
        params[key] = filters[key];
      }
    });
    return api.get('/v1/expense-claims', { params });
  },
  getClaimById: (id) => {
    return api.get(`/v1/expense-claims/${id}`);
  },
  reviewClaim: (id, reviewData) => {
    return api.put(`/v1/expense-claims/${id}/review`, reviewData);
  },
  getFinanceSummary: (month, year) => {
    return api.get('/v1/finance-summary', {
      params: { month, year }
    });
  }
};
