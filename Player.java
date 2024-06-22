/**
 * this interface represent a player
 */
public interface Player {
    /**
     * this is the turn of the player to put a mark on the board
     * @param board a board
     * @param mark a mark
     */
    public void playTurn(Board board,Mark mark);

}
