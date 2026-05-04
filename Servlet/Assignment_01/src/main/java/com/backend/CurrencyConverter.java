package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverter extends HttpServlet
{
	HashMap<String, Double> conversionRates = new HashMap<>();
	{
		 conversionRates.put("USD_INR", 94.91);
	     conversionRates.put("INR_USD", 0.011);
	     conversionRates.put("USD_EUR", 0.92);
	     conversionRates.put("EUR_USD", 1.08);
	     conversionRates.put("INR_EUR", 0.011);
	     conversionRates.put("EUR_INR", 90.0);
	}
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 String amountStr = req.getParameter("amount");
	        String from = req.getParameter("From");
	        String to = req.getParameter("To");
	        
	        resp.setContentType("text/html");

	        PrintWriter out = resp.getWriter();
	        
	        if(amountStr == null || from ==null || to==null 
	        		|| amountStr.trim().isEmpty()|| from.trim().isEmpty() || to.trim().isEmpty())
		{
				out.print("<h3 style='color:red'>Invalid input </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/currencyConverter.html");
				rd.include(req, resp);
				return;
		}
	        
	        double amount=0;
	        try
	        {
	        	amount = Double.parseDouble(amountStr);
	        }
	        catch(NumberFormatException e)
	        {
	        	  out.println("<h2 style='color:red'>Amount must be numeric</h2>");
	        	  RequestDispatcher rd = req.getRequestDispatcher("/currencyConverter.html");
				  rd.include(req, resp);
	              return;
	        }
	        
	        String key = from.toUpperCase()+ "_"+to.toUpperCase();
	        if(!conversionRates.containsKey(key))
	        {
	        	  out.println("<h2 style='color:red'>Unsupported Currency Conversion</h2>");
	        	  RequestDispatcher rd = req.getRequestDispatcher("/currencyConverter.html");
				  rd.include(req, resp);
	              return;
	        }
	        
	        double rate = conversionRates.get(key);
	        double conversionAmount = amount*rate;
	        
	        {
	        	resp.setContentType("text/html");
//	        	req.setAttribute("convertedAmt", conversionAmount);
	        	RequestDispatcher rd = req.getRequestDispatcher("/currencyConverter.html");
	        	rd.include(req, resp);
	        	out.println("<h2 style='color:green'>converted Amount : "+conversionAmount+"</h2>");
	        }
	}
}
