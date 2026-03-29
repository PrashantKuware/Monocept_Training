package Sudoku.Test;
import Sudoku.model.*;

import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        SudokuGrid sudoku = new SudokuGrid();

        int[][] grid = sudoku.getGrid();

        System.out.println("Select Difficulty Level");
        System.out.println("1 Easy (50 filled)");
        System.out.println("2 Medium (40 filled)");
        System.out.println("3 Hard (20 filled)");

        int choice = scanner.nextInt();

        int fillCount=0;

        switch(choice) {

            case 1: fillCount=50; break;
            case 2: fillCount=40; break;
            case 3: fillCount=20; break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        SudokuGenerator.fillRandomCells(grid,fillCount);

        sudoku.displayGrid();

        while(true) {

            System.out.println("Enter row (-1 to exit)");
            int row = scanner.nextInt();

            if(row==-1)
                break;

            System.out.println("Enter column");
            int col = scanner.nextInt();

            if(row<0||row>8||col<0||col>8) {

                System.out.println("Invalid position");
                continue;
            }

            if(grid[row][col]!=0) {

                System.out.println("Cell already filled");
                continue;
            }

            System.out.println("Enter value 1-9");
            int value = scanner.nextInt();

            if(value<1||value>9) {

                System.out.println("Invalid number");
                continue;
            }

            if(!SudokuValidator.isValidMove(grid,row,col,value)) {

                System.out.println("Invalid move! Violates Sudoku rules");
                continue;
            }

            sudoku.setValue(row,col,value);

            sudoku.displayGrid();
        }

        if(SudokuValidator.validateSudoku(grid))
            System.out.println("Sudoku Valid");
        else
            System.out.println("Sudoku Invalid");

    }
}