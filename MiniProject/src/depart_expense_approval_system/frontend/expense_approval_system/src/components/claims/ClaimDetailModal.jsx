import React, { useState, useEffect } from 'react';
import { expenseService } from '../../services/expenseService';
import Modal from '../common/Modal';
import { STATUS_COLORS } from '../../utils/constants';
import { formatCurrency, formatDate, formatDateTime } from '../../utils/formatters';

const ClaimDetailModal = ({ claimId, isOpen, onClose }) => {
  const [claim, setClaim] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!isOpen || !claimId) {
      setClaim(null);
      setError(null);
      return;
    }

    const fetchClaim = async () => {
      setIsLoading(true);
      setError(null);
      try {
        const data = await expenseService.getClaimById(claimId);
        setClaim(data);
      } catch (err) {
        setError(err.message || 'Failed to load claim details.');
      } finally {
        setIsLoading(false);
      }
    };

    fetchClaim();
  }, [claimId, isOpen]);

  return (
    <Modal
      isOpen={isOpen}
      title={`Claim Details #${claimId}`}
      onClose={onClose}
      showActions={false}
      className="max-w-xl"
    >
      {isLoading ? (
        <div className="py-8 text-center">
          <svg className="animate-spin h-6 w-6 text-brand-500 mx-auto" fill="none" viewBox="0 0 24 24">
            <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
            <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
          </svg>
        </div>
      ) : error ? (
        <p className="text-sm text-red-600 font-medium text-center py-4">{error}</p>
      ) : claim ? (
        <div className="space-y-4">
          <div className="flex items-center justify-between">
            <span className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-semibold border ${STATUS_COLORS[claim.status]}`}>
              {claim.status}
            </span>
            <span className="text-lg font-bold font-mono text-brand-600">{formatCurrency(claim.amount)}</span>
          </div>

          <dl className="grid grid-cols-2 gap-x-4 gap-y-3 text-sm">
            <div>
              <dt className="text-xs font-semibold text-slate-500 uppercase">Employee</dt>
              <dd className="font-semibold text-slate-800 mt-0.5">{claim.employeeName}</dd>
            </div>
            <div>
              <dt className="text-xs font-semibold text-slate-500 uppercase">Department</dt>
              <dd className="font-semibold text-slate-800 mt-0.5">{claim.department}</dd>
            </div>
            <div>
              <dt className="text-xs font-semibold text-slate-500 uppercase">Category</dt>
              <dd className="font-semibold text-slate-800 mt-0.5">{claim.category.replace(/_/g, ' ')}</dd>
            </div>
            <div>
              <dt className="text-xs font-semibold text-slate-500 uppercase">Expense Date</dt>
              <dd className="font-semibold text-slate-800 mt-0.5">{formatDate(claim.expenseDate)}</dd>
            </div>
            <div className="col-span-2">
              <dt className="text-xs font-semibold text-slate-500 uppercase">Description</dt>
              <dd className="text-slate-700 mt-0.5">{claim.description || '—'}</dd>
            </div>
            {claim.reviewRemark && (
              <div className="col-span-2">
                <dt className="text-xs font-semibold text-slate-500 uppercase">Review Remark</dt>
                <dd className="text-slate-700 mt-0.5">{claim.reviewRemark}</dd>
              </div>
            )}
            <div>
              <dt className="text-xs font-semibold text-slate-500 uppercase">Submitted</dt>
              <dd className="text-slate-600 mt-0.5 text-xs">{formatDateTime(claim.createdAt)}</dd>
            </div>
            {claim.reviewedAt && (
              <div>
                <dt className="text-xs font-semibold text-slate-500 uppercase">Reviewed</dt>
                <dd className="text-slate-600 mt-0.5 text-xs">{formatDateTime(claim.reviewedAt)}</dd>
              </div>
            )}
          </dl>
        </div>
      ) : null}
    </Modal>
  );
};

export default ClaimDetailModal;
