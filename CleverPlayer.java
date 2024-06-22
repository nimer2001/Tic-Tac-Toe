/**
 * this class represents the clever player
 */
public class CleverPlayer implements Player {
    /**
     * a constructor
     */
    public CleverPlayer() {

    }

    /**
     * this function represent the turn of the clever player
     * @param board a board
     * @param mark a mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        while (true) {
            for (int col = 0; col < board.getSize(); col++) {
                for (int row = 0; row < board.getSize(); row++) {
                    if (board.putMark(mark, row, col)) {
                        return;
                    }

                }
            }
        }
    }

}