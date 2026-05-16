package com.monocept.demo;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements Payment
{
	@Override
	public String payNow()
	{
		return "Payment made through credit card";
	}

	public CreditCardPayment() {
		System.out.println("Inside credit card payment");	}
}
