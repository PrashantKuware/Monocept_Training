package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;

class CarLoan extends Loan implements LoanEligibility
{
    public CarLoan(int id,String name,double amount,double rate) 
    throws InvalidLoanException
    {
        super(id,name,amount,rate);
        System.out.println("CarLoan Constructor Called");
    }

    public double calculateRepayment()
    {
        return principalAmount + (principalAmount * interestRate * 5)/100;
    }

    public boolean checkEligibility(double income)
    {
        return income >= 30000;
    }
}