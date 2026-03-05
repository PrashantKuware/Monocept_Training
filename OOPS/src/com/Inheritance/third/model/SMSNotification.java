package com.Inheritance.third.model;

public class SMSNotification extends Notification {

    public SMSNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public void send() {
        super.logNotification();
        System.out.println("SMS sent to " + recipient + 
                           " with message: " + message);
    }
}
