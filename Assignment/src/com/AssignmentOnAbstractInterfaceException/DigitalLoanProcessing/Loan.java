package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;

abstract class Loan
{
    protected int loanId;
    protected String borrowerName;
    protected double principalAmount;
    protected double interestRate;

    static String bankName;

    static
    {
        bankName = "Global Digital Bank";
        System.out.println("Loan System Initialized for " + bankName);
    }

    public Loan(int loanId,String borrowerName,double principalAmount,double interestRate) 
    throws InvalidLoanException
    {
        System.out.println("Loan Constructor Executed");

        if(principalAmount <= 0)
        {
            throw new InvalidLoanException("Principal amount must be positive");
        }

        if(interestRate <= 0)
        {
            throw new InvalidLoanException("Interest rate must be positive");
        }

        this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
    }

    public abstract double calculateRepayment();

    public void displayLoan()
    {
        System.out.println("Loan ID: "+loanId);
        System.out.println("Borrower Name: "+borrowerName);
        System.out.println("Principal Amount: "+principalAmount);
        System.out.println("Interest Rate: "+interestRate);
    }
}