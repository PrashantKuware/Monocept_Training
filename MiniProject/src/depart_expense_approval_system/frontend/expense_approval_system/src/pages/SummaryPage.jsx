import React, { useState, useEffect } from 'react';
import { useRole } from '../context/RoleContext';
import { expenseService } from '../services/expenseService';
import { toast } from 'react-toastify';
import Card from '../components/common/Card';
import Button from '../components/common/Button';
import { MONTHS, getYearOptions } from '../utils/constants';
import { BarChart3, Calendar, AlertTriangle, Info } from 'lucide-react';
import { formatCurrency } from '../utils/formatters';

const SummaryPage = () => {
  const { isManager } = useRole();
  const [summaries, setSummaries] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  // Period Selection
  const [period, setPeriod] = useState({
    month: new Date().getMonth() + 1,
    year: new Date().getFullYear(),
  });
  const fetchSummary = async () => {
    setIsLoading(true);
    try {
      const data = await expenseService.getFinanceSummary(period.month, period.year);
      setSummaries(data || []);
    } catch (err) {
      toast.error('Failed to compile monthly financial summary.');
    } finally {
      setIsLoading(false);
    }
  };
  useEffect(() => {
    if (isManager()) {
      fetchSummary();
    }
  }, [isManager, period.month, period.year]);
  const handlePeriodChange = (e) => {
    const { name, value } = e.target;
    setPeriod((prev) => ({ ...prev, [name]: parseInt(value) }));
  };
  const months = MONTHS;
  const years = getYearOptions(4, 0);
  if (!isManager()) {
    return (
      <div className="flex flex-col items-center justify-center py-12 px-4 bg-white rounded-2xl border border-slate-100 shadow-premium max-w-lg mx-auto">
        <AlertTriangle className="w-12 h-12 text-yellow-500 mb-4" />
        <h3 className="text-lg font-bold text-slate-800">Access Restricted</h3>
        <p className="text-sm text-slate-500 text-center mt-2">
          Only authorized Finance Managers can view organization financial summaries. Please toggle your portal role.
        </p>
      </div>
    );
  }
  return (
    <div className="space-y-6">
      
      {/* Header and Period Filter */}
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-4">
        <div className="flex items-center space-x-3">
          <div className="w-10 h-10 rounded-xl bg-violet-50 flex items-center justify-center text-violet-600">
            <BarChart3 className="w-5 h-5" />
          </div>
          <div>
            <h2 className="text-lg font-bold text-slate-800">Monthly Balance Sheet</h2>
            <p className="text-xs text-slate-500 font-medium">Verify department budgets, remaining balances, and claim counts.</p>
          </div>
        </div>
        <div className="flex items-center space-x-2 bg-white p-1.5 rounded-xl border border-slate-200 shadow-sm">
          <Calendar className="w-4 h-4 text-slate-400 ml-2" />
          <select
            name="month"
            value={period.month}
            onChange={handlePeriodChange}
            className="bg-transparent border-0 text-xs font-semibold text-slate-700 focus:ring-0 focus:outline-none cursor-pointer"
          >
            {months.map(m => <option key={m.value} value={m.value}>{m.label}</option>)}
          </select>
          <span className="text-slate-300">/</span>
          <select
            name="year"
            value={period.year}
            onChange={handlePeriodChange}
            className="bg-transparent border-0 text-xs font-semibold text-slate-700 focus:ring-0 focus:outline-none cursor-pointer"
          >
            {years.map(y => <option key={y.value} value={y.value}>{y.label}</option>)}
          </select>
        </div>
      </div>
      {/* Finance Table */}
      <Card bodyClassName="p-0">
        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-slate-50/50 text-[10px] uppercase font-bold text-slate-500 tracking-wider border-b border-slate-100">
                <th className="px-6 py-4">Department</th>
                <th className="px-6 py-4 text-right">Monthly Budget</th>
                <th className="px-6 py-4 text-right">Approved Expenses</th>
                <th className="px-6 py-4 text-right">Pending Expenses</th>
                <th className="px-6 py-4 text-right">Remaining Budget</th>
                <th className="px-6 py-4 text-center">Approved</th>
                <th className="px-6 py-4 text-center">Pending</th>
                <th className="px-6 py-4 text-center">Rejected</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100 text-sm font-medium text-slate-700">
              {isLoading ? (
                <tr>
                  <td colSpan="8" className="px-6 py-12 text-center text-slate-400">
                    <svg className="animate-spin h-6 w-6 text-brand-500 mx-auto" fill="none" viewBox="0 0 24 24">
                      <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                      <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                    </svg>
                  </td>
                </tr>
              ) : summaries.length === 0 ? (
                <tr>
                  <td colSpan="8" className="px-6 py-12 text-center text-slate-400">
                    No summary logs retrieved for this fiscal period.
                  </td>
                </tr>
              ) : (
                summaries.map((sum) => {
                  const hasExceededBudget = sum.remainingBudget < 0;
                  const isLowBudget = sum.monthlyBudget > 0 && (sum.remainingBudget / sum.monthlyBudget) <= 0.15;
                  
                  return (
                    <tr key={sum.department} className="hover:bg-slate-50/40 transition-colors">
                      <td className="px-6 py-4">
                        <span className="bg-slate-100 text-slate-800 px-2 py-0.5 rounded-md font-bold text-xs">
                          {sum.department}
                        </span>
                      </td>
                      <td className="px-6 py-4 text-right font-mono text-slate-900">
                        {sum.monthlyBudget > 0 ? formatCurrency(sum.monthlyBudget) : 'Not Set'}
                      </td>
                      <td className="px-6 py-4 text-right font-mono text-emerald-600 font-semibold">
                        {formatCurrency(sum.totalApprovedExpense)}
                      </td>
                      <td className="px-6 py-4 text-right font-mono text-amber-600 font-semibold">
                        {formatCurrency(sum.totalPendingExpense)}
                      </td>
                      <td className={`px-6 py-4 text-right font-mono font-bold ${
                        hasExceededBudget 
                          ? 'text-red-600' 
                          : isLowBudget 
                            ? 'text-yellow-600' 
                            : 'text-slate-800'
                      }`}>
                        {formatCurrency(sum.remainingBudget)}
                        {isLowBudget && !hasExceededBudget && (
                          <span className="block text-[9px] font-semibold text-yellow-600 uppercase mt-0.5">
                            Low Funds (≤15%)
                          </span>
                        )}
                      </td>
                      <td className="px-6 py-4 text-center">
                        <span className="bg-emerald-50 text-emerald-700 px-2 py-0.5 rounded-full text-xs font-semibold border border-emerald-100">
                          {sum.numberOfApprovedClaims}
                        </span>
                      </td>
                      <td className="px-6 py-4 text-center">
                        <span className="bg-amber-50 text-amber-700 px-2 py-0.5 rounded-full text-xs font-semibold border border-amber-100">
                          {sum.numberOfPendingClaims}
                        </span>
                      </td>
                      <td className="px-6 py-4 text-center">
                        <span className="bg-red-50 text-red-700 px-2 py-0.5 rounded-full text-xs font-semibold border border-red-100">
                          {sum.numberOfRejectedClaims}
                        </span>
                      </td>
                    </tr>
                  );
                })
              )}
            </tbody>
          </table>
        </div>
      </Card>
      <div className="flex items-center space-x-2 p-4 rounded-2xl bg-brand-50/50 border border-brand-100 text-xs text-brand-700">
        <Info className="w-4 h-4 shrink-0 text-brand-500" />
        <p className="font-medium">
          Remaining budgets automatically adjust as pending claims get processed. Pending and rejected claims do not consume allocated budget values.
        </p>
      </div>
    </div>
  );
};
export default SummaryPage;