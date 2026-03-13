package String;

import java.util.Scanner;

public class ValidateIPAddress {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter IP address! ");
		String ip = scanner.nextLine();
		
		if(ip.matches("^((25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$"))
		{
			System.out.println("Correct Ip : "+ip);
		}
		else {
			System.out.println("Wrong Ip : "+ip);
		}
		
	}

}
