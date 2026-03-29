package Sudoku.model;

import java.util.HashSet;

class BoxValidator extends AbstractValidator {

    public boolean validate(int[][] grid) throws InvalidSudokuException {

        for(int row=0;row<9;row+=3) {

            for(int col=0;col<9;col+=3) {

                HashSet<Integer> set = new HashSet<>();

                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {

                        int num = grid[row+i][col+j];

                        if(num==0) continue;

                        if(set.contains(num))
                            throw new InvalidSudokuException("Duplicate value in box");

                        set.add(num);
                    }
                }
            }
        }

        return true;
    }
}