package Sudoku.model;

public class SudokuValidator {

    public static boolean validateSudoku(int[][] grid) {

        try {

            RowValidator rv = new RowValidator();
            ColumnValidator cv = new ColumnValidator();
            BoxValidator bv = new BoxValidator();

            rv.validate(grid);
            cv.validate(grid);
            bv.validate(grid);

            return true;

        }
        catch(Exception e) {

            System.out.println("Invalid Sudoku: "+e.getMessage());
            return false;
        }
    }

    public static boolean isValidMove(int[][] grid,int row,int col,int value) {

        // row check
        for(int j=0;j<9;j++)
            if(grid[row][j]==value)
                return false;

        // column check
        for(int i=0;i<9;i++)
            if(grid[i][col]==value)
                return false;

        // box check
        int startRow = row-row%3;
        int startCol = col-col%3;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(grid[startRow+i][startCol+j]==value)
                    return false;

        return true;
    }
}