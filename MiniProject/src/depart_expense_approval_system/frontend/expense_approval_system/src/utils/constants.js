export const DEPARTMENTS = [
  { value: 'IT', label: 'Information Technology (IT)' },
  { value: 'HR', label: 'Human Resources (HR)' },
  { value: 'FINANCE', label: 'Finance (FINANCE)' },
  { value: 'SALES', label: 'Sales (SALES)' },
  { value: 'MARKETING', label: 'Marketing (MARKETING)' },
];

export const EXPENSE_CATEGORIES = [
  { value: 'TRAVEL', label: 'Travel & Commute' },
  { value: 'FOOD', label: 'Food & Meals' },
  { value: 'MEDICAL', label: 'Medical Claims' },
  { value: 'OFFICE_SUPPLIES', label: 'Office Supplies' },
  { value: 'TRAINING', label: 'Training & Development' },
  { value: 'SOFTWARE', label: 'Software Licenses' },
  { value: 'OTHERS', label: 'Others / Miscellaneous' },
];

export const EXPENSE_STATUSES = [
  { value: 'PENDING', label: 'Pending' },
  { value: 'APPROVED', label: 'Approved' },
  { value: 'REJECTED', label: 'Rejected' },
];

export const STATUS_COLORS = {
  PENDING: 'bg-amber-50 text-amber-700 border-amber-100',
  APPROVED: 'bg-emerald-50 text-emerald-700 border-emerald-100',
  REJECTED: 'bg-red-50 text-red-700 border-red-100',
};

export const ROLES = {
  EMPLOYEE: 'EMPLOYEE',
  MANAGER: 'MANAGER',
};

export const DEFAULT_EMPLOYEE_NAME = 'John Doe';

export const MONTHS = Array.from({ length: 12 }, (_, i) => ({
  value: i + 1,
  label: new Date(0, i).toLocaleString('default', { month: 'long' }),
}));

export const getYearOptions = (pastYears = 0, futureYears = 4) =>
  Array.from({ length: pastYears + futureYears + 1 }, (_, i) => {
    const year = new Date().getFullYear() - pastYears + i;
    return { value: year, label: year.toString() };
  });

export const ROUTES = {
  DASHBOARD: '/',
  CLAIMS: '/claims',
  SUBMIT_CLAIM: '/submit-claim',
  REVIEW_CLAIMS: '/review-claims',
  BUDGETS: '/budgets',
  SUMMARY: '/summary',
};
