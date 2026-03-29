package Sudoku.model;

public class SudokuGrid {

    private int[][] grid;

    public SudokuGrid() {
        this.grid = new int[9][9];
    }

    public SudokuGrid(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

    
    public void displayGrid() {

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                if(grid[i][j] == 0) {
                    System.out.print("(" + i + "," + j + ")" + " | ");
                }
                else {
                    System.out.print( "  "+grid[i][j] + "  "+" | ");
                }
            }

            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}