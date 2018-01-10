public class Game {

    private Player black;
    private Player white;
    private Board board;
    private GameLogic logic;
    private Printer printer;
    private  boolean blacksTurn;

    /**
     * the function creates new instance of Game
     * @param board instances of the board, the players, and the game's logic
     * @param
     * @param
     * @param
     * @param
     **/

    Game(Board board, Player black, Player white, GameLogic logic, Printer printer) {
        this.board = board;
        this.white = white;
        this.black = black;
        this.logic = logic;
        this.printer = printer;
        blacksTurn = true;
    }

    /**
     * @name : playGame
     * @parameters : no parameters
     * @return : the function runs the game
     **/

    public void playGame() {
        // In the first turn there should not be a message of last position
        boolean notFirstTurn = false;

        while (isGameNotOver()) {
            printer.printBoard(board, false);
            if (blacksTurn) {
                if (notFirstTurn)
                    printer.printLastMove(blacksTurn, white.getLastMove().getX(), white.getLastMove().getY());
                notFirstTurn = true;
                printer.printNextTurn(blacksTurn);
                if (logic.possibleMoves(blacksTurn,black.getType(),printer))
                    black.playOneTurn(blacksTurn);
                else {
                    black.declareNoMoves();
                    printer.printNoMoves();
                }
            } else {
                printer.printLastMove(blacksTurn, black.getLastMove().getX(), black.getLastMove().getY());
                printer.printNextTurn(blacksTurn);
                if (logic.possibleMoves(blacksTurn,white.getType(), printer))
                    white.playOneTurn(blacksTurn);
                else {
                    white.declareNoMoves();
                    printer.printNoMoves();
                }
            }
            blacksTurn = !blacksTurn;
        }
        //if the game is online, then one of the players is a LocalPlayer (type=3). He should notify the server that the game ended.
        if (black.getType()==3)
            black.onlineEnd();
        if (white.getType() ==3)
            white.onlineEnd();
        printer.printsWhoWon(board);
    }

    /**
     * @name : isGameNotOver
     * @parameters : no parameters
     * @return : the function returns true if the game is over or not
     **/

    private boolean isGameNotOver() {
        return (!board.isFull() && (black.getCanPlay() || white.getCanPlay()));
    }
}
