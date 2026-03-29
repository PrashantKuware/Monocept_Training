package com.ComparatorAndComparable.fifth;

import java.util.*;

class Transaction {

    private int id;
    private double amount;

    Transaction(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "Transaction { id=" + id + ", amount=" + amount + " }";
    }
}

public class TransactionTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        int id;
        double amount;

        while(true)
        {

            
            while(true)
            {
                System.out.println("Enter Transaction ID:");

                String tempId = scanner.nextLine().trim();

                if(!tempId.matches("\\d+"))
                {
                    System.out.println("Invalid ID. Enter numbers only.");
                    continue;
                }

                id = Integer.parseInt(tempId);

                if(id <= 0)
                {
                    System.out.println("ID must be greater than 0");
                    continue;
                }

                break;
            }

            // AMOUNT VALIDATION
            while(true)
            {
                System.out.println("Enter Transaction Amount:");

                String tempAmount = scanner.nextLine().trim();

                if(!tempAmount.matches("^[+]?(\\d+(\\.\\d*)?|\\.\\d+)$"))
                {
                    System.out.println("Invalid Amount");
                    continue;
                }

                amount = Double.parseDouble(tempAmount);

                if(amount <= 0)
                {
                    System.out.println("Amount must be greater than 0");
                    continue;
                }

                break;
            }

            list.add(new Transaction(id, amount));

            System.out.println("Add more transactions? (yes/no)");

            String choice = scanner.nextLine();

            if(choice.equalsIgnoreCase("no"))
                break;
        }

        Collections.sort(list, new TransactionComparator());

        System.out.println("\nSorted Transactions:");

        for(Transaction t : list)
        {
            System.out.println(t);
        }

        scanner.close();
    }
}