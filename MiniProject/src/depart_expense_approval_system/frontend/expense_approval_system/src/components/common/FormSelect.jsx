import React, { forwardRef } from 'react';
const FormSelect = forwardRef(({
  label,
  name,
  options = [],
  error,
  placeholder = 'Select an option',
  className = '',
  ...props
}, ref) => {
  return (
    <div className={`flex flex-col space-y-1.5 w-full ${className}`}>
      {label && (
        <label htmlFor={name} className="text-xs font-semibold text-slate-700 tracking-wide">
          {label}
        </label>
      )}
      <select
        ref={ref}
        id={name}
        name={name}
        className={`px-4 py-2.5 rounded-xl border text-sm font-medium transition-all duration-200 focus:outline-none focus:ring-2 bg-white ${
          error 
            ? 'border-red-300 bg-red-50/10 focus:border-red-500 focus:ring-red-200' 
            : 'border-slate-200 hover:border-slate-300 focus:border-brand-500 focus:ring-brand-100'
        }`}
        {...props}
      >
        <option value="" disabled>{placeholder}</option>
        {options.map((opt) => (
          <option key={opt.value} value={opt.value}>
            {opt.label}
          </option>
        ))}
      </select>
      {error && (
        <span className="text-[11px] font-semibold text-red-500 mt-1 pl-1">
          {error.message}
        </span>
      )}
    </div>
  );
});
FormSelect.displayName = 'FormSelect';
export default FormSelect;