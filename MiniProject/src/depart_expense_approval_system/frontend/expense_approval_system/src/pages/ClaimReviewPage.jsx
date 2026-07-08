import React, { useState, useEffect } from 'react';
import { useRole } from '../context/RoleContext';
import { expenseService } from '../services/expenseService';
import { toast } from 'react-toastify';
import Card from '../components/common/Card';
import Button from '../components/common/Button';
import Modal from '../components/common/Modal';
import { CheckSquare, ShieldCheck, ThumbsDown, ThumbsUp, AlertTriangle } from 'lucide-react';
import { formatCurrency, formatDate } from '../utils/formatters';
const ClaimReviewPage = () => {
  const { isManager } = useRole();
  const [claims, setClaims] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  // Review Dialog State
  const [selectedClaim, setSelectedClaim] = useState(null);
  const [reviewRemark, setReviewRemark] = useState('');
  const [isReviewLoading, setIsReviewLoading] = useState(false);
  const [reviewType, setReviewType] = useState('APPROVE'); // APPROVE or REJECT
  const [isModalOpen, setIsModalOpen] = useState(false);
  const fetchPendingClaims = async () => {
    setIsLoading(true);
    try {
      const response = await expenseService.getClaims({ status: 'PENDING', sort: 'createdAt,asc' });
      setClaims(response.content || []);
    } catch (err) {
      toast.error('Failed to load pending claims ledger.');
    } finally {
      setIsLoading(false);
    }
  };
  useEffect(() => {
    if (isManager()) {
      fetchPendingClaims();
    }
  }, [isManager]);
  const openReviewModal = (claim, type) => {
    setSelectedClaim(claim);
    setReviewType(type);
    setReviewRemark('');
    setIsModalOpen(true);
  };
  const handleReviewAction = async () => {
    if (reviewType === 'REJECT' && !reviewRemark.trim()) {
      toast.warning('A reason remark must be provided when rejecting reimbursement claims.');
      return;
    }
    setIsReviewLoading(true);
    try {
      const reviewPayload = {
        status: reviewType === 'APPROVE' ? 'APPROVED' : 'REJECTED',
        remark: reviewRemark.trim() || undefined,
      };
      await expenseService.reviewClaim(selectedClaim.id, reviewPayload);
      
      toast.success(
        reviewType === 'APPROVE' 
          ? 'Reimbursement claim approved successfully.' 
          : 'Reimbursement claim rejected successfully.'
      );
      
      setIsModalOpen(false);
      fetchPendingClaims();
    } catch (err) {
      // Graceful error alerts parsing business logic exceptions
      const message = err.message || 'Review submission failed.';
      if (err.errorCode === 'BUDGET_EXCEEDED') {
        toast.error(`Approval Denied: Allocated monthly budget for this department has been exceeded.`);
      } else {
        toast.error(message);
      }
    } finally {
      setIsReviewLoading(false);
    }
  };
  if (!isManager()) {
    return (
      <div className="flex flex-col items-center justify-center py-12 px-4 bg-white rounded-2xl border border-slate-100 shadow-premium max-w-lg mx-auto">
        <AlertTriangle className="w-12 h-12 text-yellow-500 mb-4" />
        <h3 className="text-lg font-bold text-slate-800">Access Restricted</h3>
        <p className="text-sm text-slate-500 text-center mt-2">
          Only authorized Finance Managers can review and process pending expense claims. Please toggle your portal role.
        </p>
      </div>
    );
  }
  return (
    <div className="space-y-6">
      <div className="flex items-center space-x-3">
        <div className="w-10 h-10 rounded-xl bg-purple-50 flex items-center justify-center text-purple-600">
          <CheckSquare className="w-5 h-5" />
        </div>
        <div>
          <h2 className="text-lg font-bold text-slate-800">Pending Review Desk</h2>
          <p className="text-xs text-slate-500 font-medium">Verify company expenses and perform budget-controlled approvals.</p>
        </div>
      </div>
      <Card bodyClassName="p-0">
        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-slate-50/50 text-[10px] uppercase font-bold text-slate-500 tracking-wider border-b border-slate-100">
                <th className="px-6 py-4">Claim ID</th>
                <th className="px-6 py-4">Employee</th>
                <th className="px-6 py-4">Dept</th>
                <th className="px-6 py-4">Category</th>
                <th className="px-6 py-4">Expense Date</th>
                <th className="px-6 py-4">Description</th>
                <th className="px-6 py-4 text-right">Amount</th>
                <th className="px-6 py-4 text-center">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100 text-sm font-medium text-slate-700">
              {isLoading ? (
                <tr>
                  <td colSpan="8" className="px-6 py-12 text-center">
                    <svg className="animate-spin h-6 w-6 text-purple-500 mx-auto" fill="none" viewBox="0 0 24 24">
                      <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                      <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                    </svg>
                  </td>
                </tr>
              ) : claims.length === 0 ? (
                <tr>
                  <td colSpan="8" className="px-6 py-12 text-center">
                    <div className="flex flex-col items-center justify-center text-slate-400">
                      <ShieldCheck className="w-10 h-10 mb-2 text-emerald-500" />
                      <p className="font-semibold text-slate-500">Review queue is clean</p>
                      <p className="text-xs text-slate-400 mt-1">No pending expense claims require actions.</p>
                    </div>
                  </td>
                </tr>
              ) : (
                claims.map((claim) => (
                  <tr key={claim.id} className="hover:bg-slate-50/40 transition-colors">
                    <td className="px-6 py-4 text-slate-400 font-mono">#{claim.id}</td>
                    <td className="px-6 py-4 text-slate-900 font-semibold">{claim.employeeName}</td>
                    <td className="px-6 py-4 text-xs">
                      <span className="bg-purple-50 text-purple-700 px-2 py-0.5 rounded-md font-semibold border border-purple-100">
                        {claim.department}
                      </span>
                    </td>
                    <td className="px-6 py-4 text-xs font-semibold text-slate-500">
                      {claim.category.replace('_', ' ')}
                    </td>
                    <td className="px-6 py-4 text-xs text-slate-500">
                      {formatDate(claim.expenseDate)}
                    </td>
                    <td className="px-6 py-4 text-xs text-slate-500 max-w-xs truncate">
                      {claim.description || '-'}
                    </td>
                    <td className="px-6 py-4 text-right text-slate-900 font-bold font-mono">
                      {formatCurrency(claim.amount)}
                    </td>
                    <td className="px-6 py-4">
                      <div className="flex items-center justify-center space-x-2">
                        <button
                          onClick={() => openReviewModal(claim, 'APPROVE')}
                          className="p-1.5 rounded-lg bg-emerald-50 border border-emerald-100 text-emerald-600 hover:bg-emerald-100 transition-colors"
                          title="Approve Claim"
                        >
                          <ThumbsUp className="w-4 h-4" />
                        </button>
                        <button
                          onClick={() => openReviewModal(claim, 'REJECT')}
                          className="p-1.5 rounded-lg bg-red-50 border border-red-100 text-red-600 hover:bg-red-100 transition-colors"
                          title="Reject Claim"
                        >
                          <ThumbsDown className="w-4 h-4" />
                        </button>
                      </div>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </Card>
      {/* Review Approval/Rejection Modal */}
      <Modal
        isOpen={isModalOpen}
        title={reviewType === 'APPROVE' ? 'Approve Expense Claim' : 'Reject Expense Claim'}
        onClose={() => setIsModalOpen(false)}
        confirmText={reviewType === 'APPROVE' ? 'Approve' : 'Reject'}
        onConfirm={handleReviewAction}
        confirmVariant={reviewType === 'APPROVE' ? 'success' : 'danger'}
        isConfirmLoading={isReviewLoading}
      >
        <div className="space-y-4">
          <div className="p-4 rounded-xl bg-slate-50 border border-slate-100 text-sm">
            <div className="flex justify-between">
              <span className="text-slate-500 font-medium">Employee Name:</span>
              <span className="font-bold text-slate-800">{selectedClaim?.employeeName}</span>
            </div>
            <div className="flex justify-between mt-2">
              <span className="text-slate-500 font-medium">Department / Period:</span>
              <span className="font-semibold text-slate-800">{selectedClaim?.department} - {selectedClaim?.expenseDate && formatDate(selectedClaim.expenseDate)}</span>
            </div>
            <div className="flex justify-between mt-2 pt-2 border-t border-slate-200">
              <span className="text-slate-500 font-medium">Claim Amount:</span>
              <span className="font-bold text-brand-600 font-mono">{selectedClaim && formatCurrency(selectedClaim.amount)}</span>
            </div>
          </div>
          <div className="flex flex-col space-y-1.5">
            <label htmlFor="remark" className="text-xs font-semibold text-slate-700">
              Review Remark {reviewType === 'REJECT' && <span className="text-red-500">*</span>}
            </label>
            <textarea
              id="remark"
              rows={3}
              value={reviewRemark}
              onChange={(e) => setReviewRemark(e.target.value)}
              placeholder={
                reviewType === 'APPROVE' 
                  ? 'Add feedback remark (Optional)...' 
                  : 'Enter rejection reason (Required)...'
              }
              className="px-4 py-2.5 rounded-xl border border-slate-200 text-sm focus:outline-none focus:ring-2 focus:ring-brand-100 focus:border-brand-500 font-medium"
            />
          </div>
        </div>
      </Modal>
    </div>
  );
};
export default ClaimReviewPage;