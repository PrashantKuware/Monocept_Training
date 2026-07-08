import React from 'react';
import Button from './Button';

const Pagination = ({ page, totalPages, totalElements, onPageChange }) => {
  if (totalPages <= 1) return null;

  return (
    <div className="flex items-center justify-between px-6 py-4 border-t border-slate-100 bg-slate-50/20">
      <span className="text-xs text-slate-500 font-medium">
        Showing page {page + 1} of {totalPages} ({totalElements} total entries)
      </span>
      <div className="flex space-x-2">
        <Button
          variant="secondary"
          className="px-3 py-1 rounded-lg text-xs"
          disabled={page === 0}
          onClick={() => onPageChange(page - 1)}
        >
          Previous
        </Button>
        <Button
          variant="secondary"
          className="px-3 py-1 rounded-lg text-xs"
          disabled={page >= totalPages - 1}
          onClick={() => onPageChange(page + 1)}
        >
          Next
        </Button>
      </div>
    </div>
  );
};

export default Pagination;
