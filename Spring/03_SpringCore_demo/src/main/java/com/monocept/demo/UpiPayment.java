package com.monocept.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements Payment
{
	@Override
	@Scope("singleton")
	public String payNow()
	{
		return "Payment made through UPI Mode";
	}

	public UpiPayment() 
	{
		System.out.println("Inside upi payment");
	}
}
