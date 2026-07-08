import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { useRole } from '../context/RoleContext';
import { budgetService } from '../services/budgetService';
import { toast } from 'react-toastify';
import Card from '../components/common/Card';
import FormInput from '../components/common/FormInput';
import FormSelect from '../components/common/FormSelect';
import Button from '../components/common/Button';
import { DEPARTMENTS, MONTHS, getYearOptions } from '../utils/constants';
import { DollarSign, PlusCircle, AlertTriangle } from 'lucide-react';
import { formatCurrency } from '../utils/formatters';

const BudgetPage = () => {
  const { isManager } = useRole();
  const [budgets, setBudgets] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [isSubmitLoading, setIsSubmitLoading] = useState(false);
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    defaultValues: {
      department: '',
      month: new Date().getMonth() + 1,
      year: new Date().getFullYear(),
      budgetAmount: '',
    }
  });
  const fetchBudgets = async () => {
    setIsLoading(true);
    try {
      const data = await budgetService.getAllBudgets();
      setBudgets(data || []);
    } catch (err) {
      toast.error('Failed to load allocated department budgets.');
    } finally {
      setIsLoading(false);
    }
  };
  useEffect(() => {
    if (isManager()) {
      fetchBudgets();
    }
  }, [isManager]);
  const onSubmit = async (data) => {
    setIsSubmitLoading(true);
    try {
      const budgetPayload = {
        ...data,
        month: parseInt(data.month),
        year: parseInt(data.year),
        budgetAmount: parseFloat(data.budgetAmount),
      };
      await budgetService.createBudget(budgetPayload);
      toast.success('Department budget allocated successfully!');
      reset({
        department: '',
        month: new Date().getMonth() + 1,
        year: new Date().getFullYear(),
        budgetAmount: '',
      });
      fetchBudgets();
    } catch (err) {
      // Catch duplicate error conflicts 409
      if (err.errorCode === 'DUPLICATE_BUDGET') {
        toast.error('Conflict: A monthly budget is already allocated for this department in the selected period.');
      } else {
        toast.error(err.message || 'Budget allocation failed.');
      }
    } finally {
      setIsSubmitLoading(false);
    }
  };
  const departments = DEPARTMENTS.map((d) => ({ value: d.value, label: d.value }));
  const months = MONTHS;
  const years = getYearOptions(0, 4);
  if (!isManager()) {
    return (
      <div className="flex flex-col items-center justify-center py-12 px-4 bg-white rounded-2xl border border-slate-100 shadow-premium max-w-lg mx-auto">
        <AlertTriangle className="w-12 h-12 text-yellow-500 mb-4" />
        <h3 className="text-lg font-bold text-slate-800">Access Restricted</h3>
        <p className="text-sm text-slate-500 text-center mt-2">
          Only authorized Finance Managers can configure and allocate department budgets. Please toggle your portal role.
        </p>
      </div>
    );
  }
  return (
    <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
      
      {/* Allocate Budget Form */}
      <div className="space-y-6 lg:col-span-1">
        <div className="flex items-center space-x-3">
          <div className="w-10 h-10 rounded-xl bg-emerald-50 flex items-center justify-center text-emerald-600">
            <PlusCircle className="w-5 h-5" />
          </div>
          <div>
            <h2 className="text-lg font-bold text-slate-800">Allocate Budget</h2>
            <p className="text-xs text-slate-500 font-medium">Define monthly department expenditure caps.</p>
          </div>
        </div>
        <Card>
          <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
            <FormSelect
              label="Organization Department"
              name="department"
              placeholder="Select Department"
              options={departments}
              error={errors.department}
              {...register('department', { required: 'Department allocation is required' })}
            />
            <div className="grid grid-cols-2 gap-3">
              <FormSelect
                label="Budget Month"
                name="month"
                placeholder="Month"
                options={months}
                error={errors.month}
                {...register('month', { required: 'Month is required' })}
              />
              <FormSelect
                label="Budget Year"
                name="year"
                placeholder="Year"
                options={years}
                error={errors.year}
                {...register('year', { required: 'Year is required' })}
              />
            </div>
            <FormInput
              label="Budget Limit Amount ($)"
              name="budgetAmount"
              type="number"
              step="0.01"
              placeholder="0.00"
              error={errors.budgetAmount}
              {...register('budgetAmount', {
                required: 'Budget amount is required',
                min: { value: 0.01, message: 'Budget must be greater than zero' }
              })}
            />
            <Button type="submit" className="w-full mt-4" isLoading={isSubmitLoading}>
              Save Budget Allocation
            </Button>
          </form>
        </Card>
      </div>
      {/* Allocated Budgets Listings */}
      <div className="lg:col-span-2 space-y-6">
        <div className="flex items-center space-x-3">
          <div className="w-10 h-10 rounded-xl bg-brand-50 flex items-center justify-center text-brand-600">
            <DollarSign className="w-5 h-5" />
          </div>
          <div>
            <h2 className="text-lg font-bold text-slate-800">Budget Configurations</h2>
            <p className="text-xs text-slate-500 font-medium">Historical trace logs of all defined department funding limits.</p>
          </div>
        </div>
        <Card bodyClassName="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-left border-collapse">
              <thead>
                <tr className="bg-slate-50/50 text-[10px] uppercase font-bold text-slate-500 tracking-wider border-b border-slate-100">
                  <th className="px-6 py-4">Department</th>
                  <th className="px-6 py-4">Fiscal Period</th>
                  <th className="px-6 py-4 text-right">Allocated Budget</th>
                  <th className="px-6 py-4">Updated At</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-slate-100 text-sm font-medium text-slate-700">
                {isLoading ? (
                  <tr>
                    <td colSpan="4" className="px-6 py-8 text-center text-slate-400">
                      <svg className="animate-spin h-5 w-5 text-brand-500 mx-auto" fill="none" viewBox="0 0 24 24">
                        <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                        <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                      </svg>
                    </td>
                  </tr>
                ) : budgets.length === 0 ? (
                  <tr>
                    <td colSpan="4" className="px-6 py-12 text-center text-slate-400">
                      No budgets allocated yet. Use the left panel to configure budgets.
                    </td>
                  </tr>
                ) : (
                  budgets.map((b) => (
                    <tr key={b.id} className="hover:bg-slate-50/40 transition-colors">
                      <td className="px-6 py-4">
                        <span className="bg-slate-100 text-slate-800 px-2 py-0.5 rounded-md font-semibold text-xs">
                          {b.department}
                        </span>
                      </td>
                      <td className="px-6 py-4">
                        {new Date(0, b.month - 1).toLocaleString('default', { month: 'long' })}, {b.year}
                      </td>
                      <td className="px-6 py-4 text-right font-bold font-mono text-slate-900">
                        {formatCurrency(b.budgetAmount)}
                      </td>
                      <td className="px-6 py-4 text-xs text-slate-400">
                        {new Date(b.updatedAt).toLocaleString()}
                      </td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        </Card>
      </div>
    </div>
  );
};
export default BudgetPage;