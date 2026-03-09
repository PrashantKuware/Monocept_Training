package String;

import java.util.Scanner;

public class EmailAnalyzer {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String domainName, userName, modifiedUserName;
		int specialCharacter;
		
		System.out.println("Enter the Email");
		String email = scanner.nextLine().trim().toLowerCase();
		
		specialCharacter = email.indexOf('@');
		userName = email.substring(0,specialCharacter);
		domainName = email.substring(specialCharacter+1,email.length());
		modifiedUserName = userName.replace('.', '_');
		
		
		System.out.println("Username: "+userName);
		System.out.println("Domain: "+domainName);	
		System.out.println("Total characters in username: "+userName.length());	
			
		
			if(userName.matches(".*\\d.*"))
			{
				System.out.println("Contains digit");
				
			}
			else
			{
				System.out.println("Not Contains digit");
			}
		
		System.out.println("Modified username: "+modifiedUserName);	
	
		scanner.close();
	}

}
