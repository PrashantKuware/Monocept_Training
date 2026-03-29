package com.String;

import java.util.Arrays;
import java.util.Scanner;

public class WordFrequencyCounter {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the sentence");
		String sentence = scanner.nextLine().trim().toLowerCase();
		String[] splitSentence = sentence.split(" ");
		Arrays.sort(splitSentence);
		int count = 1;
		for(int i=0;i<splitSentence.length-1;i++) 
		{
			int j=i+1;
			
			if(splitSentence[i].equals(splitSentence[i+1]))
			{
				count++;
			}
			else
			{
				System.out.println(splitSentence[i] +" "+count);
				count=1;
			}
		}
		System.out.println(splitSentence[splitSentence.length-1] +" "+count);
		
		scanner.close();
	}

}
