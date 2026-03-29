package Sudoku.model;

import java.util.HashSet;

class ColumnValidator extends AbstractValidator {

    public boolean validate(int[][] grid) throws InvalidSudokuException {

        for(int col=0;col<9;col++) {

            HashSet<Integer> set = new HashSet<>();

            for(int row=0;row<9;row++) {

                int num = grid[row][col];

                if(num==0) continue;

                if(set.contains(num))
                    throw new InvalidSudokuException("Duplicate value in column "+col);

                set.add(num);
            }
        }

        return true;
    }
}