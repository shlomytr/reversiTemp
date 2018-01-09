

public abstract class Player {

    protected GameLogic logic;
    protected boolean canPlay;
    protected int type;
    protected Point lastMove ;

    /**
     * @name : Player
     * @parameters : no parameters
     * @return : the function creates a new instance of player
     **/

    Player(GameLogic l){
    this.logic = l;
    }

    /**
     * @name : getCanPlay
     * @parameters : no parameters
     * @return : the function returns true if the player has a possible move to play or false otherwise
     **/

    public boolean getCanPlay(){
        return canPlay;
    }

    /**
     * prints that the player has no moves
     **/
    abstract void declareNoMoves();

    /**
     *@return the last move of the player as a point
     **/
    Point getLastMove() {
        return lastMove;
    }

    /**
     * @name : getType
     * @parameters : no parameters
     * @return : the function returns the type of the player (HumanPlayer, AIPlayer etc)
     **/
    int getType() {
        return this.type;
    }

    /**
     * @name : playOneTurn
     * @parameters : true if it's the black's player turn, false otherwise
     * @return : the function makes a move in the game
     **/

    abstract void playOneTurn(boolean blacksTurn);

    /**
     * @name : onlineEnd
     * @parameters : no parameters
     * @return : in LocalPlayer only the function sends a message to the server declaring that the current game has ended
     **/
    abstract void onlineEnd();

}
