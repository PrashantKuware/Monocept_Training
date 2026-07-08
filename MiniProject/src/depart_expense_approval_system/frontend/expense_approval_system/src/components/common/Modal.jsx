import React from 'react';
import { X } from 'lucide-react';
import Button from './Button';
const Modal = ({
  isOpen,
  title,
  children,
  onClose,
  confirmText,
  onConfirm,
  confirmVariant = 'primary',
  isConfirmLoading = false,
  showActions = true,
  className = '',
}) => {
  if (!isOpen) return null;
  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-slate-900/60 backdrop-blur-sm transition-all duration-300">
      <div className={`bg-white rounded-2xl shadow-hoverPremium border border-slate-100 max-w-lg w-full overflow-hidden transform scale-100 transition-transform duration-300 ${className}`}>
        
        {/* Header */}
        <div className="flex items-center justify-between px-6 py-4 border-b border-slate-100 bg-slate-50/50">
          <h3 className="text-base font-bold text-slate-800">{title}</h3>
          <button 
            onClick={onClose} 
            className="text-slate-400 hover:text-slate-600 hover:bg-slate-100 p-1.5 rounded-lg transition-colors"
          >
            <X className="w-4 h-4" />
          </button>
        </div>
        {/* Content */}
        <div className="p-6">
          {children}
        </div>
        {/* Footer Actions */}
        {showActions && (
          <div className="flex items-center justify-end space-x-3 px-6 py-4 border-t border-slate-100 bg-slate-50/50">
            <Button variant="secondary" onClick={onClose}>
              Cancel
            </Button>
            {onConfirm && (
              <Button 
                variant={confirmVariant} 
                onClick={onConfirm} 
                isLoading={isConfirmLoading}
              >
                {confirmText || 'Confirm'}
              </Button>
            )}
          </div>
        )}
      </div>
    </div>
  );
};
export default Modal;