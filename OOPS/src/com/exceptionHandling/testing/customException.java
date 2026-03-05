package com.exceptionHandling.testing;

import java.util.Scanner;

class InvalidPasswordException extends Exception 
{

    public InvalidPasswordException(String message) 
    {
        super(message);
    }
}

public class customException 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the password:");
            String password = scanner.nextLine().trim();

            if (!isValidPassword(password)) 
            {   
                throw new InvalidPasswordException(
                        "Password must be atleast 8 characters and contain only letters and digits");
            }

            System.out.println("Valid password");

        } catch (InvalidPasswordException e) 
        {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Session ended");
            scanner.close();
        }
    }

    public static boolean isValidPassword(String password) 
    {

        if (password != null && password.matches("^[a-zA-Z0-9]{8}$")) 
        {
            return true;
        }
        return false;
    }
}