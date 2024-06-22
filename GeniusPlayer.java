/**
 * This is the class of the genius player,that implements the interface player
 */
public class GeniusPlayer implements Player {
    /**
     * the constructor of the genius player
     */
    public GeniusPlayer() {
    }

    /**
     * this function put a mark on the board,for the genius player.
     * @param board the board
     * @param mark the mark he wants to put
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        while (true) {
            if (board.getMark(0, 0) == Mark.BLANK || board.getMark(0, 0) == mark) {
                for (int i = 0; i < board.getSize(); i++) {
                    if (board.putMark(mark, i, i)) {
                        return;
                    }
                }
            }
            for (int i = 1; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    if (board.putMark(mark, i, j)) {
                        return;
                    }
                }
            }
            for (int j = 0; j < board.getSize(); j++) {
                if (board.putMark(mark, 0, j)) {
                    return;
                }
            }
        }
    }
}
