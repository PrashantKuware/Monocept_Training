package com.collectionAssigment.LibraryBookCirculationSystem.model;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class Conditions 
{
	  // ***************************************** ADD BOOK ****************************************
	
	public static void addBook(Scanner scanner, List<Product> list)
	{
		System.out.print("Enter Id: ");
	    String idInput = scanner.nextLine();

	    if (!idInput.matches("\\d+")) {
	        System.out.println(" Invalid ID");
	        return;
	    }

	    int id = Integer.parseInt(idInput);

	    boolean exist = false;
	    for (Product p : list) {
	        if (p.getId() == id) {
	            exist = true;
	            return;
	        }
	    }

	    if (exist) {
	        System.out.println(" Duplicate book id not allowed");
	        return;
	    }

	 
	    System.out.print("Enter Book Name: ");
	    String name = scanner.nextLine();

	    if (!name.matches("[a-zA-Z0-9]+")) {
	        System.out.println(" Invalid book name.");
	        return;
	    }

	    System.out.print("Enter Author Name: ");
	    String authorName = scanner.nextLine();

	    if (!authorName.matches("[a-zA-Z ]+")) {
	        System.out.println(" Invalid author name");
	        return;
	    }

	    System.out.println("1: Academic, 2: Magazine");
	    System.out.print("Enter type: ");
	    String typeInput = scanner.nextLine();

	    if (!typeInput.matches("\\d+")) {
	        System.out.println(" Invalid type!");
	        return;
	    }

	    int type = Integer.parseInt(typeInput);

	    Product book;

	    if (type == 1) {
	        book = new AcademicBook(id, name, authorName);
	    } else if (type == 2) {
	        book = new MagazineBook(id, name, authorName);
	    } else {
	        System.out.println(" Invalid type choice");
	        return;
	    }

	    list.add(book);
	    System.out.println(" Book added successfully!");
	    return;
	}
	
	  // ***************************************** SORT BOOK ****************************************

	
	public static void sortBook(Scanner scanner, List<Product> list, Queue<Product> queue)
	{
		if (list.isEmpty()) {
            System.out.println("No books to sort.");
            return;
        }

        System.out.println("1 for sort by id");
        System.out.println("2 for sort by book name");

        String sortInput = scanner.nextLine();

        if (!sortInput.matches("\\d+")) {
            System.out.println(" Invalid choice!");
            return;
        }

        int sortChoice = Integer.parseInt(sortInput);

        if (sortChoice == 1) {
            Collections.sort(list, new sortById());
        } else if (sortChoice == 2) {
            Collections.sort(list, new sortByName());
        } else {
            System.out.println(" Invalid sort option");
            return;
        }

        System.out.println(" Sorting done.");
        return;
	}
	
	  // ***************************************** ISSUE BOOK ****************************************

	
	public static void issueBook(Scanner scanner, List<Product> list, Queue<Product> queue)
	{
		System.out.print("Enter Book ID for issue: ");
        String issueInput = scanner.nextLine();

        if (!issueInput.matches("\\d+")) {
            System.out.println(" Invalid ID!");
            return;
        }

        int issueId = Integer.parseInt(issueInput);

        Product found = null;

        for (Product p : list) {
            if (p.getId() == issueId) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("Book not found!");
            return;
        }

        if (found.status != STATUS.AVAILABLE) {
            System.out.println(" Book not available!");
            return;
        }

        queue.add(found);
        found.status = STATUS.PROCESSING;

        System.out.println("Added to queue");
        return;
	}
	
	  // ***************************************** PROCESS BOOK ****************************************
	
	public  static void processQueue(Queue<Product> queue)
	{
		 if (!queue.isEmpty()) {
             Product p = queue.poll();
             p.status = STATUS.ISSUED;
             System.out.println(" Issued: " + p.getName());
         } else {
             System.out.println("Queue empty");
         }
         return;
	}
	
	  // ***************************************** DISPLAY BOOK ****************************************
	
	public static void displayBook(List<Product> list)
	{
		  if (list.isEmpty()) {
              System.out.println("No books available.");
          } else {
              for (Product p : list) {
                  System.out.println(p);
              }
          }
          return;
	}
	
	  // ***************************************** EXIT BOOK ****************************************

	public static void exit(Scanner scanner)
	{
		System.out.println("Exiting...");
		scanner.close();

	}
}
