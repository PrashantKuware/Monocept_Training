package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;

import java.util.Scanner;

public class LoanSystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Loan[] loans = new Loan[5];

        int count = 0;

        while(count < loans.length)
        {
            try
            {
                int id;
                String name;
                double amount;
                double rate;

                while(true)
                {
                    System.out.print("Enter Loan ID (3 digits): ");
                    String input = sc.nextLine();

                    if(input.matches("\\d{3}"))
                    {
                        id = Integer.parseInt(input);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Loan ID");
                    }
                }

                while(true)
                {
                    System.out.print("Enter Borrower Name: ");
                    name = sc.nextLine();

                    if(name.matches("[A-Za-z ]{3,30}"))
                        break;
                    else
                        System.out.println("Invalid Name");
                }

                while(true)
                {
                    System.out.print("Enter Loan Amount: ");
                    String input = sc.nextLine();

                    if(input.matches("\\d+(\\.\\d+)?"))
                    {
                        amount = Double.parseDouble(input);
                        break;
                    }
                    else
                        System.out.println("Invalid Amount");
                }

                while(true)
                {
                    System.out.print("Enter Interest Rate: ");
                    String input = sc.nextLine();

                    if(input.matches("\\d+(\\.\\d+)?"))
                    {
                        rate = Double.parseDouble(input);
                        break;
                    }
                    else
                        System.out.println("Invalid Interest Rate");
                }

                int type;

                while(true)
                {
                    System.out.println("Select Loan Type");
                    System.out.println("1 Home Loan");
                    System.out.println("2 Car Loan");
                    System.out.println("3 Education Loan");

                    String input = sc.nextLine();

                    if(input.matches("[123]"))
                    {
                        type = Integer.parseInt(input);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid choice");
                    }
                }

                Loan loan;

                if(type == 1)
                    loan = new HomeLoan(id,name,amount,rate);
                else if(type == 2)
                    loan = new CarLoan(id,name,amount,rate);
                else
                    loan = new EducationLoan(id,name,amount,rate);

                loans[count] = loan;
                count++;

            }
            catch(InvalidLoanException e)
            {
                System.out.println("Error: "+e.getMessage());
            }

            System.out.print("Add another loan? (yes/no): ");
            String choice = sc.nextLine();

            if(!choice.equalsIgnoreCase("yes"))
                break;
        }

        System.out.println("\n------ Loan Processing ------");

        for(int i=0;i<count;i++)
        {
            Loan loan = loans[i];

            loan.displayLoan();

            LoanEligibility eligibility = (LoanEligibility) loan;

            System.out.print("Enter Borrower Monthly Income: ");
            double income = sc.nextDouble();
            sc.nextLine();

            if(eligibility.checkEligibility(income))
            {
                System.out.println("Eligible for loan");
                System.out.println("Repayment Amount: "+loan.calculateRepayment());
            }
            else
            {
                System.out.println("Not Eligible for this loan");
            }

            System.out.println("----------------------------");
        }

        sc.close();
    }
}