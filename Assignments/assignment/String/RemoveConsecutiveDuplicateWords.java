package String;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveConsecutiveDuplicateWords {

	public static void main(String[] args) 
	{
//		Java java is Is most powerful language Language
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the word! ");
		String word = scanner.nextLine().trim().toLowerCase();
		String[] splitWord = word.split(" ");
		
		
		int n=splitWord.length;
		for(int i=1;i<n;i++)
		{
			if(splitWord[i].equals(splitWord[i-1]))
			{
				continue;
			}
			else
			{
				
				System.out.println(splitWord[i-1]);
			}
		}
		 System.out.println(splitWord[n - 1]);
		
	}

}
