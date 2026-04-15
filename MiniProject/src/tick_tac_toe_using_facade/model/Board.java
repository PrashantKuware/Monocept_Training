package tick_tac_toe_using_facade.model;


public class Board {
    private char[] cells = new char[9];

    public Board() {
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public char[] getCells() {
        return cells;
    }

    public boolean isCellEmpty(int index) {
        return cells[index] != 'X' && cells[index] != 'O';
    }

    public void placeMove(int index, char symbol) {
        cells[index] = symbol;
    }

    public void printBoard() {
        System.out.println("\n " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
        System.out.println("---|---|---");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8] + "\n");
    }
}