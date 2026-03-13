package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;

class EducationLoan extends Loan implements LoanEligibility
{
    public EducationLoan(int id,String name,double amount,double rate) 
    throws InvalidLoanException
    {
        super(id,name,amount,rate);
        System.out.println("EducationLoan Constructor Called");
    }

    public double calculateRepayment()
    {
        return principalAmount + (principalAmount * interestRate * 3)/100;
    }

    public boolean checkEligibility(double income)
    {
        return income >= 20000;
    }
}