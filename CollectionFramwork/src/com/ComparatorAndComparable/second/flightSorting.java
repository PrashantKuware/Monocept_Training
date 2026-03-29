package com.ComparatorAndComparable.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


 class Flight 
{
	
	private String airline;
	private Double  fare;

	Flight( String airline, Double  fare)
	{
		
		this.airline = airline;
		this.fare = fare;
	}
	
	
	public String getairline()
	{
		return airline;
	}
	public Double getfare()
	{
		return fare;
	}
	
	public String toString()
	{
		return "Candidate { "+ "AirlLine Name : " + airline +", " + "Fare : "+fare +"}";
	}

	
}

 class flightSorting 
{
	 
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Flight> list = new ArrayList<>();
		
		String airline = null;
		Double fare;
		int sortingChoice ;
		
		
		while(true)
		{
			while(true)
			{
				System.out.println("Enter the airline name");
				airline = scanner.nextLine().trim();
				if(!airline.matches("[a-zA-Z]+"))
				{
					System.out.println("Airline Name is incorrect");
					continue;
				}
				break;
			}
			while(true)
			{
				System.out.println("Enter the fare");
				String tempFare = scanner.nextLine().trim();
				if(!tempFare.matches("^[+]?(\\d+(\\.\\d*)?|\\.\\d+)$"))
				{			
					System.out.println("Fare is incorrect");
					continue;
				}
				fare = Double.parseDouble(tempFare);
				break;
			}	
				
				list.add(new Flight(airline,fare));
				
				 System.out.print("Add more flight data? (yes/no): ");
		            String choice = scanner.nextLine();

		            if(choice.equalsIgnoreCase("no"))
		                break;
			
		}
		
		while(true)
		{
			System.out.println("Enter choice for sorting");
			System.out.println("1 for airline name sorting");
			System.out.println("2 for fare sorting");
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
			Collections.sort(list, new airlineComparator());
		case 2 :
			Collections.sort(list, new fareComparator());
		}
		
		
	
		for(Flight st : list)
		{
			System.out.println(st);	
		}
		
		scanner.close();

	}
	
}
