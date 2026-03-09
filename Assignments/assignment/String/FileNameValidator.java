package String;

import java.util.Scanner;

public class FileNameValidator 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file");
		String file = scanner.nextLine().trim();
		boolean isPDF = file.toLowerCase().endsWith(".pdf");
		boolean containsFinal = file.toLowerCase().contains("final");
		
		String replaceUnderscoreInFileName = file.replace("_", " ").toUpperCase();
		int index = replaceUnderscoreInFileName.lastIndexOf('.');
		String fileName = replaceUnderscoreInFileName.substring(0,index);
		String extension = replaceUnderscoreInFileName.substring(index+1);
		
		
		System.out.println("File Name : " + fileName);
		System.out.println("Extension : " +extension);
		System.out.println("Is PDF : " +(isPDF?"Yes":"No"));
		System.out.println("Contains final : "+(containsFinal ? "Yes":"No"));
	
		scanner.close();
	}
}
