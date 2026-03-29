package Sudoku.model;

abstract class AbstractValidator {

    public abstract boolean validate(int[][] grid) throws InvalidSudokuException;

}