package tick_tac_toe_using_facade.model.validation;

import tick_tac_toe_using_facade.model.exception.InvalidInputException;

public class InputValidator {

    public static int validateMenu(String input) throws InvalidInputException {
        if (!input.matches("[12]"))
            throw new InvalidInputException("Enter 1 or 2 only");

        return Integer.parseInt(input);
    }
}