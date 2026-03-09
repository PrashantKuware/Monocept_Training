package String;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) 
	{
//		Java is fun
//		avaJ si nuf 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Sentence ");
		String sentence = scanner.nextLine().trim();
		String[] sentenceArray = sentence.split(" ");
		
		for(String s : sentenceArray)
		{
			String newWord="";
			for(int i=s.length()-1;i>=0;i--)
			{
				 newWord = newWord+s.charAt(i);
			}
			System.out.print(newWord+" ");
			
			
		}
	}

}
