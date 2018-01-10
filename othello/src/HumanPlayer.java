import java.util.Scanner;

public class HumanPlayer extends Player {

    protected Printer printer;
    protected GameLogic logic;
    protected boolean canPlay;
    protected int type;
    protected Point lastMove;
    private Scanner scanner = new Scanner(System.in);

    /**
     * the constructor
     * @param  gameLogic gameLogic
     * @param  printer printer
     **/
    HumanPlayer(GameLogic gameLogic, Printer printer) {
        super(gameLogic);
        this.canPlay = true;
        this.type = 1;
        this.printer = printer;
    }

    @Override
    void declareNoMoves() {

    }

    @Override
    void playOneTurn(boolean blacksTurn) {
        this.canPlay = true;
        printer.printEnterNextTurn();
        int row, col;
        row = scanner.nextInt();
        col = scanner.nextInt();
// TODO: 09/01/18
        //if its invalid move.
        while (!logic.getPosCell(row - 1, col - 1)) {
            printer.PrintInvalidMove();
            row = scanner.nextInt();
            col = scanner.nextInt();
        }

        lastMove.setX(row - 1);
        lastMove.setY( col - 1);
        logic.move(blacksTurn, row -1, col - 1);
    }

    @Override
    void onlineEnd() {
    }
}
