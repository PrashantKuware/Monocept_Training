package tick_tac_toe_using_facade.model.io;


import java.util.Scanner;

public class InputReader {

    private Scanner sc = new Scanner(System.in);

    public int readInt() {
        while (true) {
            try {
                String input = sc.nextLine();   // ONLY nextLine
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Enter again:");
            }
        }
    }

    public String readLine() {
        return sc.nextLine();   // clean input
    }
}