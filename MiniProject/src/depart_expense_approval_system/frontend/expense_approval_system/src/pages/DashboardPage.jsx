import React, { useState, useEffect } from 'react';
import { useRole } from '../context/RoleContext';
import { useNavigate } from 'react-router-dom';
import { expenseService } from '../services/expenseService';
import Card from '../components/common/Card';
import Button from '../components/common/Button';
import { 
  FilePlus, CheckSquare, DollarSign, 
  TrendingUp, Clock, AlertTriangle, ShieldCheck, Wallet
} from 'lucide-react';
import { formatCurrency } from '../utils/formatters';

const DashboardPage = () => {
  const { role, isManager, employeeName } = useRole();
  const navigate = useNavigate();
  
  const [stats, setStats] = useState({
    approvedSum: 0,
    pendingSum: 0,
    approvedCount: 0,
    pendingCount: 0,
    totalBudget: 0,
    remainingBudget: 0,
    lowBudgetDepts: 0,
  });
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const fetchStats = async () => {
      setIsLoading(true);
      try {
        const now = new Date();
        const month = now.getMonth() + 1;
        const year = now.getFullYear();

        if (isManager()) {
          const [claimsResponse, summaryData] = await Promise.all([
            expenseService.getClaims({ status: 'PENDING', page: 0, size: 1 }),
            expenseService.getFinanceSummary(month, year),
          ]);

          const summaries = summaryData || [];
          let totalBudget = 0;
          let totalApproved = 0;
          let totalPending = 0;
          let totalRemaining = 0;
          let lowBudgetDepts = 0;

          summaries.forEach((s) => {
            totalBudget += Number(s.monthlyBudget) || 0;
            totalApproved += Number(s.totalApprovedExpense) || 0;
            totalPending += Number(s.totalPendingExpense) || 0;
            totalRemaining += Number(s.remainingBudget) || 0;
            if (s.monthlyBudget > 0 && s.remainingBudget / s.monthlyBudget <= 0.15) {
              lowBudgetDepts++;
            }
          });

          setStats({
            approvedSum: totalApproved,
            pendingSum: totalPending,
            approvedCount: summaries.reduce((n, s) => n + s.numberOfApprovedClaims, 0),
            pendingCount: claimsResponse.totalElements ?? summaries.reduce((n, s) => n + s.numberOfPendingClaims, 0),
            totalBudget,
            remainingBudget: totalRemaining,
            lowBudgetDepts,
          });
        } else {
          const claimsResponse = await expenseService.getClaims({
            employeeName,
            page: 0,
            size: 50,
          });
          const list = claimsResponse.content || [];
          
          let approvedS = 0;
          let pendingS = 0;
          let approvedC = 0;
          let pendingC = 0;
          list.forEach((c) => {
            if (c.status === 'APPROVED') {
              approvedS += c.amount;
              approvedC++;
            } else if (c.status === 'PENDING') {
              pendingS += c.amount;
              pendingC++;
            }
          });
          setStats({
            approvedSum: approvedS,
            pendingSum: pendingS,
            approvedCount: approvedC,
            pendingCount: pendingC,
            totalBudget: 0,
            remainingBudget: 0,
            lowBudgetDepts: 0,
          });
        }
      } catch (err) {
        console.error('Error fetching dashboard statistics', err);
      } finally {
        setIsLoading(false);
      }
    };
    fetchStats();
  }, [role, employeeName]);
  return (
    <div className="space-y-8">
      {/* Welcome Banner */}
      <div className="p-6 md:p-8 rounded-3xl bg-gradient-to-r from-brand-900 via-brand-800 to-slate-950 text-white shadow-premium flex flex-col md:flex-row md:items-center justify-between gap-6">
        <div className="space-y-2">
          <h2 className="text-xl md:text-2xl font-extrabold tracking-tight">Welcome to ExpenseFlow</h2>
          <p className="text-xs text-brand-200 font-medium max-w-md">
            Organize company spendings, manage monthly department budgets, and expedite reimbursement approvals under one secure ledger.
          </p>
        </div>
        <div className="flex shrink-0 gap-3">
          {isManager() ? (
            <>
              <Button onClick={() => navigate('/review-claims')} variant="success" className="px-5">
                Review Queue
              </Button>
              <Button onClick={() => navigate('/budgets')} variant="secondary" className="bg-transparent border-white/20 text-white hover:bg-white/10">
                Setup Budget
              </Button>
            </>
          ) : (
            <Button onClick={() => navigate('/submit-claim')} variant="primary" className="px-6 py-2.5 rounded-xl shadow-premium">
              <FilePlus className="w-4 h-4 mr-2" />
              File Claim
            </Button>
          )}
        </div>
      </div>
      {/* Numerical Widgets */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-5">
        {isManager() ? (
          <>
            <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
              <div className="w-12 h-12 rounded-xl bg-brand-50 text-brand-600 flex items-center justify-center">
                <Wallet className="w-6 h-6" />
              </div>
              <div>
                <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Total Budget (This Month)</p>
                <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
                  {isLoading ? '...' : formatCurrency(stats.totalBudget)}
                </h3>
              </div>
            </div>
            <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
              <div className="w-12 h-12 rounded-xl bg-emerald-50 text-emerald-600 flex items-center justify-center">
                <TrendingUp className="w-6 h-6" />
              </div>
              <div>
                <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Approved Expenses</p>
                <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
                  {isLoading ? '...' : formatCurrency(stats.approvedSum)}
                </h3>
              </div>
            </div>
            <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
              <div className="w-12 h-12 rounded-xl bg-amber-50 text-amber-600 flex items-center justify-center">
                <Clock className="w-6 h-6" />
              </div>
              <div>
                <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Pending Queue</p>
                <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
                  {isLoading ? '...' : stats.pendingCount}
                </h3>
              </div>
            </div>
            <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
              <div className="w-12 h-12 rounded-xl bg-violet-50 text-violet-600 flex items-center justify-center">
                <DollarSign className="w-6 h-6" />
              </div>
              <div>
                <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Remaining Budget</p>
                <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
                  {isLoading ? '...' : formatCurrency(stats.remainingBudget)}
                </h3>
                {stats.lowBudgetDepts > 0 && !isLoading && (
                  <p className="text-[10px] text-amber-600 font-semibold mt-0.5">
                    {stats.lowBudgetDepts} dept(s) low on funds
                  </p>
                )}
              </div>
            </div>
          </>
        ) : (
          <>
        <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-emerald-50 text-emerald-600 flex items-center justify-center">
            <TrendingUp className="w-6 h-6" />
          </div>
          <div>
            <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Approved Sum</p>
            <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
              {isLoading ? '...' : formatCurrency(stats.approvedSum)}
            </h3>
          </div>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-amber-50 text-amber-600 flex items-center justify-center">
            <Clock className="w-6 h-6" />
          </div>
          <div>
            <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Pending Sum</p>
            <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
              {isLoading ? '...' : formatCurrency(stats.pendingSum)}
            </h3>
          </div>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-purple-50 text-purple-600 flex items-center justify-center">
            <ShieldCheck className="w-6 h-6" />
          </div>
          <div>
            <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Approved Claims</p>
            <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
              {isLoading ? '...' : stats.approvedCount}
            </h3>
          </div>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-100 shadow-premium flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-brand-50 text-brand-600 flex items-center justify-center">
            <CheckSquare className="w-6 h-6" />
          </div>
          <div>
            <p className="text-xs font-semibold text-slate-500 uppercase tracking-wider">Pending Reviews</p>
            <h3 className="text-lg font-bold text-slate-800 font-mono mt-1">
              {isLoading ? '...' : stats.pendingCount}
            </h3>
          </div>
        </div>
          </>
        )}
      </div>
      {/* Navigation and Flow Guides */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <Card title="Portal Action Guide" subtitle="Learn what actions are available based on your role.">
          <div className="space-y-4">
            <div className="flex items-start space-x-3 p-3 rounded-xl bg-slate-50 border border-slate-100">
              <div className="w-8 h-8 rounded-lg bg-brand-50 text-brand-600 flex items-center justify-center shrink-0">
                <FilePlus className="w-4 h-4" />
              </div>
              <div>
                <h4 className="text-xs font-bold text-slate-800">Claim Submission</h4>
                <p className="text-[11px] text-slate-500 mt-0.5">Employees can create claims detailing amounts, categories, and receipts.</p>
              </div>
            </div>
            <div className="flex items-start space-x-3 p-3 rounded-xl bg-slate-50 border border-slate-100">
              <div className="w-8 h-8 rounded-lg bg-emerald-50 text-emerald-600 flex items-center justify-center shrink-0">
                <DollarSign className="w-4 h-4" />
              </div>
              <div>
                <h4 className="text-xs font-bold text-slate-800">Budget Controls</h4>
                <p className="text-[11px] text-slate-500 mt-0.5">Managers set department spending caps. Claims cannot be approved beyond limits.</p>
              </div>
            </div>
            <div className="flex items-start space-x-3 p-3 rounded-xl bg-slate-50 border border-slate-100">
              <div className="w-8 h-8 rounded-lg bg-purple-50 text-purple-600 flex items-center justify-center shrink-0">
                <CheckSquare className="w-4 h-4" />
              </div>
              <div>
                <h4 className="text-xs font-bold text-slate-800">Reimbursement Audits</h4>
                <p className="text-[11px] text-slate-500 mt-0.5">Managers review claims, input feedback, and reject or approve claims securely.</p>
              </div>
            </div>
          </div>
        </Card>
        <Card title="Organization Spend Invariants" subtitle="Standard rules guiding claims processing.">
          <div className="space-y-3 text-xs font-medium text-slate-600">
            <div className="flex items-center space-x-2">
              <span className="w-1.5 h-1.5 rounded-full bg-brand-500"></span>
              <p>Budget calculations check Approved sums only (excl. Pending/Rejected).</p>
            </div>
            <div className="flex items-center space-x-2">
              <span className="w-1.5 h-1.5 rounded-full bg-brand-500"></span>
              <p>Approved claims lock final status and cannot be edited or reviewed again.</p>
            </div>
            <div className="flex items-center space-x-2">
              <span className="w-1.5 h-1.5 rounded-full bg-brand-500"></span>
              <p>Budget caps are enforced instantly at the thread level during approval.</p>
            </div>
            <div className="flex items-center space-x-2">
              <span className="w-1.5 h-1.5 rounded-full bg-brand-500"></span>
              <p>Rejections require writing comments explaining why approval failed.</p>
            </div>
            
            <div className="mt-4 p-3 rounded-xl bg-amber-50 border border-amber-100 flex items-start space-x-2 text-[11px] text-amber-700">
              <AlertTriangle className="w-4 h-4 shrink-0 text-amber-600 mt-0.5" />
              <p className="leading-normal">
                <strong>Simulate Roles:</strong> You can switch back and forth between Employee and Finance Manager roles using the portal button in the navigation header.
              </p>
            </div>
          </div>
        </Card>
      </div>
    </div>
  );
};
export default DashboardPage;