import java.util.Scanner;

public class  ConsolePrinter implements Printer {
    @Override
    public void printNextTurn(boolean blacksTurn) {
        if (blacksTurn)
            System.out.println("The next move - Player x:\n\n");
        else
            System.out.println("The next move - Player o:\n\n");
    }

    @Override
    public void printNoMoves() {
        System.out.println("No possible moves, the turn goes to the next player. Press a key and then enter to continue\n");
        Scanner scanner = new Scanner(System.in);
        char k = scanner.next().charAt(0);
    }

    @Override
    public void printLastMove(boolean blacksTurn, int i, int j) {
        if (!blacksTurn)
            System.out.println("The last move of player x was: (" + i + 1 + "," + j + 1 + ")\n");
        else
            System.out.println("The last move of player o was: (" + i + 1 + "," + j + 1 + ")\n");
    }

    @Override
    public void printBoard(Board b, boolean onlyPrintBoard) {

    }

    @Override
    public void printsWhoWon(Board b) {

    }

    @Override
    public void printEnterNextTurn() {

    }

    @Override
    public void PrintInvalidMove() {

    }

    @Override
    public void printPosMoves(Board b) {

    }
}
