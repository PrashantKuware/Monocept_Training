package com.collectionAssigment.LibraryBookCirculationSystem.test;

import java.util.*;
import com.collectionAssigment.LibraryBookCirculationSystem.model.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        Queue<Product> queue = new LinkedList<>();

        while (true) {
        	System.out.println("***************************");
            System.out.println("\nWelcome to the library\n");
            System.out.println("1 Add Book");
            System.out.println("2 Sort Books");
            System.out.println("3 Issue Book");
            System.out.println("4 Process Queue");
            System.out.println("5 Display Books");
            System.out.println("6 Exit");

          
            System.out.print("Enter choice: ");
            String choiceInput = scanner.nextLine().trim();

            if (!choiceInput.matches("\\d+")) {
                System.out.println("Invalid input! Enter number only.");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            switch (choice) {

                // ************ ADD BOOK ********************
                case 1:
                	Conditions.addBook(scanner, list);
                    break;

//                    System.out.print("Enter Id: ");
//                    String idInput = scanner.nextLine();
//
//                    if (!idInput.matches("\\d+")) {
//                        System.out.println(" Invalid ID");
//                        break;
//                    }
//
//                    int id = Integer.parseInt(idInput);
//
//                    boolean exist = false;
//                    for (Product p : list) {
//                        if (p.getId() == id) {
//                            exist = true;
//                            break;
//                        }
//                    }
//
//                    if (exist) {
//                        System.out.println(" Duplicate book id not allowed");
//                        break;
//                    }
//
//                 
//                    System.out.print("Enter Book Name: ");
//                    String name = scanner.nextLine();
//
//                    if (!name.matches("[a-zA-Z ]+")) {
//                        System.out.println(" Invalid book name! Only alphabets allowed.");
//                        break;
//                    }
//
//                    System.out.print("Enter Author Name: ");
//                    String authorName = scanner.nextLine();
//
//                    if (!authorName.matches("[a-zA-Z ]+")) {
//                        System.out.println(" Invalid author name");
//                        break;
//                    }
//
//                    System.out.println("1: Academic, 2: Magazine");
//                    System.out.print("Enter type: ");
//                    String typeInput = scanner.nextLine();
//
//                    if (!typeInput.matches("\\d+")) {
//                        System.out.println(" Invalid type!");
//                        break;
//                    }
//
//                    int type = Integer.parseInt(typeInput);
//
//                    Product book;
//
//                    if (type == 1) {
//                        book = new AcademicBook(id, name, authorName);
//                    } else if (type == 2) {
//                        book = new MagazineBook(id, name, authorName);
//                    } else {
//                        System.out.println(" Invalid type choice");
//                        break;
//                    }
//
//                    list.add(book);
//                    System.out.println(" Book added successfully!");
//                    break;

                // ************ SORT BOOK ********************
                case 2:
                	Conditions.sortBook(scanner, list, queue);
                    break;
//                    if (list.isEmpty()) {
//                        System.out.println("No books to sort.");
//                        break;
//                    }
//
//                    System.out.println("1 for sort by id");
//                    System.out.println("2 for sort by book name");
//
//                    String sortInput = scanner.nextLine();
//
//                    if (!sortInput.matches("\\d+")) {
//                        System.out.println(" Invalid choice!");
//                        break;
//                    }
//
//                    int sortChoice = Integer.parseInt(sortInput);
//
//                    if (sortChoice == 1) {
//                        Collections.sort(list, new sortById());
//                    } else if (sortChoice == 2) {
//                        Collections.sort(list, new sortByName());
//                    } else {
//                        System.out.println(" Invalid sort option");
//                        break;
//                    }
//
//                    System.out.println(" Sorting done.");
//                    break;

                
                case 3:
                	Conditions.issueBook(scanner, list, queue);
                    break;
              
                case 4:

                	Conditions.processQueue( queue);
                    break;

                case 5:

                	Conditions.displayBook( list);
                    break;

                case 6:
                	Conditions.exit( scanner);
                	 
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}