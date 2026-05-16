package com.monocept.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MobilePayment implements Payment
{
	@Override
	public String payNow()
	{
		return "Payment made through Mobile Phone";
	}

	public MobilePayment() 
	{
		System.out.println("Inside mobile payment");	
	}
}
