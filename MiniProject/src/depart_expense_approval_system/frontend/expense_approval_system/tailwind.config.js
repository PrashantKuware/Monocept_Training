/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          50: '#f0f7ff',
          100: '#e0effe',
          200: '#bbddfc',
          300: '#7cc0fa',
          400: '#389df6',
          500: '#0e7ee6',
          600: '#0261be',
          700: '#034e9a',
          800: '#07437f',
          900: '#0c396a',
          950: '#082449',
        },
        slate: {
          950: '#0b1329',
        }
      },
      fontFamily: {
        sans: ['Inter', 'system-ui', 'sans-serif'],
      },
      boxShadow: {
        premium: '0 4px 20px -2px rgba(14, 126, 230, 0.08), 0 2px 8px -1px rgba(14, 126, 230, 0.04)',
        hoverPremium: '0 12px 30px -4px rgba(14, 126, 230, 0.12), 0 4px 12px -2px rgba(14, 126, 230, 0.06)',
      }
    },
  },
  plugins: [],
}