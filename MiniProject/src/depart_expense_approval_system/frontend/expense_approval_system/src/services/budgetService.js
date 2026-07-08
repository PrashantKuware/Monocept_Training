import api from './api';
export const budgetService = {
  createBudget: (budgetData) => {
    return api.post('/v1/budgets', budgetData);
  },
  
  getAllBudgets: () => {
    return api.get('/v1/budgets');
  },
  
  getBudgetById: (id) => {
    return api.get(`/v1/budgets/${id}`);
  }
};