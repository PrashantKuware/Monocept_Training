import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { useRole } from '../context/RoleContext';
import { expenseService } from '../services/expenseService';
import { toast } from 'react-toastify';
import Card from '../components/common/Card';
import FormInput from '../components/common/FormInput';
import FormSelect from '../components/common/FormSelect';
import Button from '../components/common/Button';
import { DEPARTMENTS, EXPENSE_CATEGORIES } from '../utils/constants';
import { getTodayDateString } from '../utils/formatters';
import { FileSpreadsheet, AlertTriangle } from 'lucide-react';

const ClaimSubmissionPage = () => {
  const { isEmployee, employeeName } = useRole();
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    defaultValues: {
      employeeName: employeeName,
      department: '',
      category: '',
      amount: '',
      expenseDate: getTodayDateString(),
      description: '',
    }
  });
  const onSubmit = async (data) => {
    setIsLoading(true);
    try {
      // Clean inputs
      const claimPayload = {
        ...data,
        employeeName: data.employeeName.trim(),
        amount: parseFloat(data.amount),
      };
      await expenseService.submitClaim(claimPayload);
      toast.success('Expense claim submitted successfully for review!');
      reset();
      navigate('/claims');
    } catch (err) {
      toast.error(err.message || 'Failed to submit claim. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };
  const departments = DEPARTMENTS;
  const categories = EXPENSE_CATEGORIES;
  if (!isEmployee()) {
    return (
      <div className="flex flex-col items-center justify-center py-12 px-4 bg-white rounded-2xl border border-slate-100 shadow-premium max-w-lg mx-auto">
        <AlertTriangle className="w-12 h-12 text-yellow-500 mb-4" />
        <h3 className="text-lg font-bold text-slate-800">Access Restricted</h3>
        <p className="text-sm text-slate-500 text-center mt-2">
          Only organization employees are authorized to submit new expense claims. Please use the top-right toggle to switch your portal role.
        </p>
      </div>
    );
  }
  return (
    <div className="max-w-2xl mx-auto space-y-6">
      <div className="flex items-center space-x-3">
        <div className="w-10 h-10 rounded-xl bg-brand-50 flex items-center justify-center text-brand-600">
          <FileSpreadsheet className="w-5 h-5" />
        </div>
        <div>
          <h2 className="text-lg font-bold text-slate-800">Submit Expense Claim</h2>
          <p className="text-xs text-slate-500 font-medium">Initialize a reimbursement request for company review.</p>
        </div>
      </div>
      <Card>
        <form onSubmit={handleSubmit(onSubmit)} className="space-y-5">
            <FormInput
              label="Employee Full Name"
              name="employeeName"
              placeholder="e.g. John Doe"
              readOnly
              error={errors.employeeName}
            {...register('employeeName', {
              required: 'Employee name is required',
              minLength: { value: 2, message: 'Name must be at least 2 characters' },
              maxLength: { value: 100, message: 'Name must not exceed 100 characters' },
              validate: (val) => val.trim().length >= 2 || 'Name must not be spaces only'
            })}
          />
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <FormSelect
              label="Department"
              name="department"
              placeholder="Choose Department"
              options={departments}
              error={errors.department}
              {...register('department', { required: 'Department is required' })}
            />
            <FormSelect
              label="Expense Category"
              name="category"
              placeholder="Choose Category"
              options={categories}
              error={errors.category}
              {...register('category', { required: 'Category is required' })}
            />
          </div>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <FormInput
              label="Expense Amount ($)"
              name="amount"
              type="number"
              step="0.01"
              placeholder="0.00"
              error={errors.amount}
              {...register('amount', {
                required: 'Amount is required',
                min: { value: 0.01, message: 'Amount must be greater than zero' },
                max: { value: 100000.00, message: 'Amount must not exceed 100,000.00' }
              })}
            />
            <FormInput
              label="Expense Date"
              name="expenseDate"
              type="date"
              max={getTodayDateString()}
              error={errors.expenseDate}
              {...register('expenseDate', {
                required: 'Expense date is required',
                validate: (val) => new Date(val) <= new Date() || 'Expense date cannot be in the future'
              })}
            />
          </div>
          <div className="flex flex-col space-y-1.5 w-full">
            <label htmlFor="description" className="text-xs font-semibold text-slate-700 tracking-wide">
              Description / Business Purpose (Optional)
            </label>
            <textarea
              id="description"
              rows={4}
              placeholder="e.g. Flight travel for annual engineering offsite client meets..."
              className={`px-4 py-2.5 rounded-xl border text-sm font-medium transition-all duration-200 focus:outline-none focus:ring-2 ${
                errors.description 
                  ? 'border-red-300 bg-red-50/10 focus:border-red-500 focus:ring-red-200' 
                  : 'border-slate-200 hover:border-slate-300 focus:border-brand-500 focus:ring-brand-100'
              }`}
              {...register('description', {
                maxLength: { value: 500, message: 'Description must not exceed 500 characters' }
              })}
            />
            {errors.description && (
              <span className="text-[11px] font-semibold text-red-500 mt-1 pl-1">
                {errors.description.message}
              </span>
            )}
          </div>
          <div className="flex items-center justify-end space-x-3 pt-3 border-t border-slate-100">
            <Button variant="secondary" onClick={() => navigate('/')} disabled={isLoading}>
              Cancel
            </Button>
            <Button type="submit" isLoading={isLoading}>
              Submit Request
            </Button>
          </div>
        </form>
      </Card>
    </div>
  );
};
export default ClaimSubmissionPage;