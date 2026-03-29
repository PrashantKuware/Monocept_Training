package com.ComparatorAndComparable.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


 class Movies
{
	
	private String movieName;
	private int year;

	
	Movies( String movieName, int year)
	{
		
		this.movieName = movieName;
		this.year = year;
	}
	
	
	public String getMovieName()
	{
		return movieName;
	}
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return "Candidate { "+ "Movie Name : " + movieName +", " + "Year : "+year +"}";
	}

	
}

 class moviesSort 
{
	 
	
	public static void main(String[] args)
	{
		ArrayList<Movies> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		String movieName = null;
		int sortingChoice, year ;
		
		
		while(true)
		{
			while(true)
			{
				System.out.println("Enter the Movie name");
				movieName = scanner.nextLine().trim();
				if(!movieName.matches("[a-zA-Z]+"))
				{
					System.out.println("Movie Name is incorrect");
					continue;
				}
				break;
			}
			while(true)
			{
				System.out.println("Enter the Year");
				String tempYear = scanner.nextLine().trim();
				if(!tempYear.matches("\\d+"))
				{
					System.out.println("Movie Year is incorrect");
					continue;
				}
				year = Integer.parseInt(tempYear);
				break;
			}	
				
				list.add(new Movies(movieName,year));
				
				 System.out.print("Add more students? (yes/no): ");
		            String choice = scanner.nextLine();

		            if(choice.equalsIgnoreCase("no"))
		                break;
			
		}
		
		while(true)
		{
			System.out.println("Enter choice for sorting");
			System.out.println("1 for Movie Name sorting");
			System.out.println("2 for Year sorting");
			sortingChoice = scanner.nextInt();
			if(sortingChoice == 1 || sortingChoice == 2)
			{
				break;
			}
			System.out.println("Incorrect choice. choose either 1 or 2");
		}
		
		switch(sortingChoice)
		{
		case 1 :
			Collections.sort(list, new nameComparator());
			break;
		case 2 :
			Collections.sort(list, new yearComparator());
			break;
		}
		
		
	
		for(Movies st : list)
		{
			System.out.println(st);	
		}
		
		

	}
	
}
