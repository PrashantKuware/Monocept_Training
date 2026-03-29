package Sudoku.model;
import java.util.HashSet;

class RowValidator extends AbstractValidator {

    public boolean validate(int[][] grid) throws InvalidSudokuException {

        for(int i=0;i<9;i++) {

            HashSet<Integer> set = new HashSet<>();

            for(int j=0;j<9;j++) {

                int num = grid[i][j];

                if(num==0) continue;

                if(set.contains(num))
                    throw new InvalidSudokuException("Duplicate value in row "+i);

                set.add(num);
            }
        }

        return true;
    }
}