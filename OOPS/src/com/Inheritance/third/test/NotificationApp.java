package com.Inheritance.third.test;

import java.util.Scanner;

import com.Inheritance.third.model.EmailNotification;
import com.Inheritance.third.model.Notification;
import com.Inheritance.third.model.PushNotification;
import com.Inheritance.third.model.SMSNotification;

public class NotificationApp {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        Notification email = new EmailNotification(
                "user@gmail.com", "Welcome to our service!");

        Notification sms = new SMSNotification(
                "+91-9876543210", "Your OTP is 1234");

        Notification push = new PushNotification(
                "UserDevice123", "You have a new update");

        email.send();
        sms.send();
        push.send();
    }
}
