package tick_tac_toe_using_facade.model.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException(String msg) {
        super(msg);
    }
}