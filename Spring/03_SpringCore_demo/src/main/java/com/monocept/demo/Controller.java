package com.monocept.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	private Payment myPay;
	private Payment mySecondPay;
	
	@Autowired
	public void demoPay(@Qualifier("upiPayment") Payment pay, @Qualifier("upiPayment") Payment mySecondPay)
	{
		this.myPay = pay;
		this.mySecondPay=mySecondPay;
	}
	
	@GetMapping("/check")
	
	public String getCheck() 
	{

		return "Is my myPay==mySecondPay : "+(myPay==mySecondPay);
	}
	
	@GetMapping("/makePayment")
	
	public String getPayment() {

		return myPay.payNow();
	}
}
