package tick_tac_toe_using_facade.model.exception;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String msg) {
        super(msg);
    }
}