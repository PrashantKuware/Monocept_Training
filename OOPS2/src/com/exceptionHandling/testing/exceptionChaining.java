package com.exceptionHandling.testing;

class PaymentProcessor {

	public static void processPayment() {

		try {
			String paymentDetails = null;

			
			System.out.println(paymentDetails.length());

		} catch (NullPointerException e) {

			throw new RuntimeException("Payment processing failed", e);
		}
	}
}

public class exceptionChaining {

	public static void main(String[] args) {

		try {
			PaymentProcessor.processPayment();

		} catch (RuntimeException e) {

			System.out.println("Final Exception: " + e);
			System.out.println("--- Cause Chain ---");

			Throwable cause = e;
			while (cause != null) {
				System.out.println("Exception: " + cause);
				cause = cause.getCause();
			}
		}
	}
}