import React from 'react';
const Card = ({
  children,
  title,
  subtitle,
  actions,
  className = '',
  bodyClassName = '',
}) => {
  return (
    <div className={`premium-card overflow-hidden ${className}`}>
      {/* Header if title exists */}
      {(title || subtitle || actions) && (
        <div className="flex items-center justify-between px-6 py-4 border-b border-slate-100 bg-slate-50/20">
          <div>
            {title && <h3 className="text-sm font-bold text-slate-800 tracking-wide">{title}</h3>}
            {subtitle && <p className="text-[11px] text-slate-500 font-medium mt-0.5">{subtitle}</p>}
          </div>
          {actions && <div className="flex items-center space-x-2">{actions}</div>}
        </div>
      )}
      
      {/* Body content */}
      <div className={`p-6 ${bodyClassName}`}>
        {children}
      </div>
    </div>
  );
};
export default Card;