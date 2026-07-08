import React, { useState, useEffect } from 'react';
import { useRole } from '../context/RoleContext';
import { expenseService } from '../services/expenseService';
import Card from '../components/common/Card';
import Button from '../components/common/Button';
import Pagination from '../components/common/Pagination';
import ClaimDetailModal from '../components/claims/ClaimDetailModal';
import useDebounce from '../hooks/useDebounce';
import {
  DEPARTMENTS,
  EXPENSE_CATEGORIES,
  EXPENSE_STATUSES,
  STATUS_COLORS,
  MONTHS,
  getYearOptions,
} from '../utils/constants';
import { AlertCircle, Search, Calendar, Eye } from 'lucide-react';
import { formatCurrency, formatDate } from '../utils/formatters';

const ClaimListPage = () => {
  const { isEmployee, employeeName } = useRole();
  const [claims, setClaims] = useState([]);
  const [totalPages, setTotalPages] = useState(0);
  const [totalElements, setTotalElements] = useState(0);
  const [isLoading, setIsLoading] = useState(false);
  const [selectedClaimId, setSelectedClaimId] = useState(null);

  const [filters, setFilters] = useState({
    department: '',
    status: '',
    category: '',
    employeeName: '',
    month: '',
    year: '',
    page: 0,
    size: 10,
    sort: 'createdAt,desc',
  });

  const debouncedEmployeeName = useDebounce(filters.employeeName);

  const buildQueryFilters = () => {
    const query = { ...filters, employeeName: debouncedEmployeeName };
    if (isEmployee()) {
      query.employeeName = employeeName;
    }
    return query;
  };

  const fetchClaims = async () => {
    setIsLoading(true);
    try {
      const response = await expenseService.getClaims(buildQueryFilters());
      setClaims(response.content || []);
      setTotalPages(response.totalPages || 0);
      setTotalElements(response.totalElements || 0);
    } catch (err) {
      console.error(err);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchClaims();
  }, [
    filters.page,
    filters.department,
    filters.status,
    filters.category,
    filters.month,
    filters.year,
    debouncedEmployeeName,
    employeeName,
  ]);

  const handleFilterChange = (e) => {
    const { name, value } = e.target;
    setFilters((prev) => ({ ...prev, [name]: value, page: 0 }));
  };

  const handlePageChange = (newPage) => {
    setFilters((prev) => ({ ...prev, page: newPage }));
  };

  const clearFilters = () => {
    setFilters({
      department: '',
      status: '',
      category: '',
      employeeName: '',
      month: '',
      year: '',
      page: 0,
      size: 10,
      sort: 'createdAt,desc',
    });
  };

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-4">
        <div>
          <h2 className="text-lg font-bold text-slate-800">
            {isEmployee() ? 'My Expense Claims' : 'Operational Claims Ledger'}
          </h2>
          <p className="text-xs text-slate-500 font-medium">
            {isEmployee()
              ? `Showing claims submitted by ${employeeName}.`
              : 'Verify employee expense submissions and check status logs.'}
          </p>
        </div>
        {!isEmployee() && (
          <Button variant="secondary" onClick={clearFilters} className="self-end md:self-auto">
            Clear Filters
          </Button>
        )}
      </div>

      <Card bodyClassName="p-4 md:p-6">
        <div className="space-y-4">
          <div className={`grid grid-cols-1 sm:grid-cols-2 ${isEmployee() ? 'md:grid-cols-3' : 'md:grid-cols-4'} gap-4`}>
            {!isEmployee() && (
              <div className="relative">
                <Search className="absolute left-3.5 top-3 w-4 h-4 text-slate-400" />
                <input
                  type="text"
                  name="employeeName"
                  value={filters.employeeName}
                  onChange={(e) => setFilters((prev) => ({ ...prev, employeeName: e.target.value, page: 0 }))}
                  placeholder="Search Employee..."
                  className="w-full pl-10 pr-4 py-2 rounded-xl border border-slate-200 text-sm focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
                />
              </div>
            )}
            <select
              name="department"
              value={filters.department}
              onChange={handleFilterChange}
              className="px-4 py-2 bg-white rounded-xl border border-slate-200 text-sm focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            >
              <option value="">All Departments</option>
              {DEPARTMENTS.map((d) => (
                <option key={d.value} value={d.value}>{d.label}</option>
              ))}
            </select>
            <select
              name="category"
              value={filters.category}
              onChange={handleFilterChange}
              className="px-4 py-2 bg-white rounded-xl border border-slate-200 text-sm focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            >
              <option value="">All Categories</option>
              {EXPENSE_CATEGORIES.map((c) => (
                <option key={c.value} value={c.value}>{c.label}</option>
              ))}
            </select>
            <select
              name="status"
              value={filters.status}
              onChange={handleFilterChange}
              className="px-4 py-2 bg-white rounded-xl border border-slate-200 text-sm focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            >
              <option value="">All Statuses</option>
              {EXPENSE_STATUSES.map((s) => (
                <option key={s.value} value={s.value}>{s.label}</option>
              ))}
            </select>
          </div>

          <div className="flex flex-wrap items-center gap-4 pt-2 border-t border-slate-100">
            <div className="flex items-center space-x-2">
              <Calendar className="w-4 h-4 text-slate-400" />
              <span className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Date Period:</span>
            </div>
            <select
              name="month"
              value={filters.month}
              onChange={handleFilterChange}
              className="px-3 py-1.5 bg-white rounded-lg border border-slate-200 text-xs focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            >
              <option value="">All Months</option>
              {MONTHS.map((m) => (
                <option key={m.value} value={m.value}>{m.label}</option>
              ))}
            </select>
            <select
              name="year"
              value={filters.year}
              onChange={handleFilterChange}
              className="px-3 py-1.5 bg-white rounded-lg border border-slate-200 text-xs focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            >
              <option value="">All Years</option>
              {getYearOptions(4, 0).map((y) => (
                <option key={y.value} value={y.value}>{y.label}</option>
              ))}
            </select>
          </div>
        </div>
      </Card>

      <Card bodyClassName="p-0">
        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-slate-50/50 text-[10px] uppercase font-bold text-slate-500 tracking-wider border-b border-slate-100">
                <th className="px-6 py-4">Claim ID</th>
                {!isEmployee() && <th className="px-6 py-4">Employee</th>}
                <th className="px-6 py-4">Department</th>
                <th className="px-6 py-4">Category</th>
                <th className="px-6 py-4">Date</th>
                <th className="px-6 py-4 text-right">Amount</th>
                <th className="px-6 py-4">Status</th>
                <th className="px-6 py-4">Remark</th>
                <th className="px-6 py-4 text-center">View</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100 text-sm font-medium text-slate-700">
              {isLoading ? (
                <tr>
                  <td colSpan={isEmployee() ? 8 : 9} className="px-6 py-12 text-center text-slate-400">
                    <svg className="animate-spin h-6 w-6 text-brand-500 mx-auto" fill="none" viewBox="0 0 24 24">
                      <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                      <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                    </svg>
                  </td>
                </tr>
              ) : claims.length === 0 ? (
                <tr>
                  <td colSpan={isEmployee() ? 8 : 9} className="px-6 py-12 text-center">
                    <div className="flex flex-col items-center justify-center text-slate-400">
                      <AlertCircle className="w-8 h-8 mb-2 text-slate-300" />
                      <p className="font-semibold text-slate-500">No expense claims match this search query</p>
                      <p className="text-xs text-slate-400 mt-1">Try clearing filters or adjusting parameters.</p>
                    </div>
                  </td>
                </tr>
              ) : (
                claims.map((claim) => (
                  <tr key={claim.id} className="hover:bg-slate-50/40 transition-colors">
                    <td className="px-6 py-4 text-slate-400 font-mono">#{claim.id}</td>
                    {!isEmployee() && (
                      <td className="px-6 py-4 text-slate-900">{claim.employeeName}</td>
                    )}
                    <td className="px-6 py-4 text-xs">
                      <span className="bg-slate-100 text-slate-800 px-2 py-0.5 rounded-md font-semibold">
                        {claim.department}
                      </span>
                    </td>
                    <td className="px-6 py-4 text-xs font-semibold text-slate-500">
                      {claim.category.replace(/_/g, ' ')}
                    </td>
                    <td className="px-6 py-4 text-xs text-slate-500">
                      {formatDate(claim.expenseDate)}
                    </td>
                    <td className="px-6 py-4 text-right text-slate-900 font-semibold font-mono">
                      {formatCurrency(claim.amount)}
                    </td>
                    <td className="px-6 py-4">
                      <span className={`inline-flex items-center px-2 py-0.5 rounded-full text-xs font-semibold border ${STATUS_COLORS[claim.status]}`}>
                        {claim.status}
                      </span>
                    </td>
                    <td className="px-6 py-4 text-xs font-medium text-slate-400 max-w-xs truncate">
                      {claim.reviewRemark || '-'}
                    </td>
                    <td className="px-6 py-4 text-center">
                      <button
                        onClick={() => setSelectedClaimId(claim.id)}
                        className="p-1.5 rounded-lg bg-brand-50 border border-brand-100 text-brand-600 hover:bg-brand-100 transition-colors"
                        title="View Details"
                      >
                        <Eye className="w-4 h-4" />
                      </button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>

        {!isLoading && (
          <Pagination
            page={filters.page}
            totalPages={totalPages}
            totalElements={totalElements}
            onPageChange={handlePageChange}
          />
        )}
      </Card>

      <ClaimDetailModal
        claimId={selectedClaimId}
        isOpen={!!selectedClaimId}
        onClose={() => setSelectedClaimId(null)}
      />
    </div>
  );
};

export default ClaimListPage;
