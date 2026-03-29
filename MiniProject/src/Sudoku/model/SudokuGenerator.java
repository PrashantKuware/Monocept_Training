package Sudoku.model;

import java.util.Random;

public class SudokuGenerator 
{

    public static void fillRandomCells(int[][] grid,int count) {

        Random rand = new Random();

        int filled = 0;

        while(filled < count) {

            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            int value = rand.nextInt(9)+1;

            if(grid[row][col]==0 &&
                    SudokuValidator.isValidMove(grid,row,col,value)) {

                grid[row][col] = value;

                filled++;
            }
        }
    }
}