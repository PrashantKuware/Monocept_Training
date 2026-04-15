package tick_tac_toe_using_facade.model.facade;


import tick_tac_toe_using_facade.model.validation.InputValidator;
import tick_tac_toe_using_facade.model.exception.InvalidInputException;
import tick_tac_toe_using_facade.model.io.InputReader;

public class Menu {

    public static int showMenu(InputReader input) {
        while (true) {
            try {
                System.out.println("1. Human vs Human");
                System.out.println("2. Human vs Computer");

                return InputValidator.validateMenu(input.readLine());

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}