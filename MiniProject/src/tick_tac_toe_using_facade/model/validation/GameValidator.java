package tick_tac_toe_using_facade.model.validation;

import tick_tac_toe_using_facade.model.exception.InvalidMoveException;

public class GameValidator {

    public static void validateMove(char[] c, int pos) throws InvalidMoveException {
        if (pos < 1 || pos > 9)
            throw new InvalidMoveException("Position must be 1-9");

        if (c[pos - 1] == 'X' || c[pos - 1] == 'O')
            throw new InvalidMoveException("Cell already occupied");
    }

    public static boolean checkWin(char[] c, char s) {
        int[][] p = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] a : p)
            if (c[a[0]] == s && c[a[1]] == s && c[a[2]] == s)
                return true;

        return false;
    }

    public static boolean isDraw(char[] c) {
        for (char x : c)
            if (x != 'X' && x != 'O')
                return false;
        return true;
    }
}