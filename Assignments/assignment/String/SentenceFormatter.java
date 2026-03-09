package String;

import java.util.Scanner;

public class SentenceFormatter {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter sentence");
		String sentence = scanner.nextLine().trim().toLowerCase();
		String changeString = sentence.replace("fun","interesting");
		String capitalizeFirstLetter = changeString.substring(0,1).toUpperCase()+changeString.substring(1);
		String[] splitSentence = capitalizeFirstLetter.split(" ");
		
		
		System.out.println("Formatted Sentence : " +capitalizeFirstLetter);
		System.out.println("Total words : " +splitSentence.length);
		System.out.println("First words : " +splitSentence[0]);
		System.out.println("Last words : " +splitSentence[splitSentence.length-1]);

		scanner.close();
	}

}
