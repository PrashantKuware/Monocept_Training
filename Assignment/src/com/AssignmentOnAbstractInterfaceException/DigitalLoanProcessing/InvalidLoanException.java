package AssignmentOnAbstractInterfaceException.DigitalLoanProcessing;
class InvalidLoanException extends Exception
{
    public InvalidLoanException(String message)
    {
        super(message);
    }
}