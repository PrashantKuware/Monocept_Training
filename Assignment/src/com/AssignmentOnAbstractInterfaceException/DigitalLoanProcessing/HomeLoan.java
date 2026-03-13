package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;

class HomeLoan extends Loan implements LoanEligibility
{
    public HomeLoan(int id,String name,double amount,double rate) 
    throws InvalidLoanException
    {
        super(id,name,amount,rate);
        System.out.println("HomeLoan Constructor Called");
    }

    public double calculateRepayment()
    {
        return principalAmount + (principalAmount * interestRate * 10)/100;
    }

    public boolean checkEligibility(double income)
    {
        return income >= 50000;
    }
}