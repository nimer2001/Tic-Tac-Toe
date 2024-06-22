import java.util.Random;

/**
 * this class represent the whatever player
 */
public class WhateverPlayer implements Player {
    private final  Random random;

    /**
     * a constructor
     */
    public WhateverPlayer() {
        this.random = new Random();
    }

    /**
     * this function  puts a mark on the board,based on the whatever player strategy.
     * @param board a board
     * @param mark a mark
     */
    public void playTurn(Board board, Mark mark) {
        while (true) {
            int random_row = random.nextInt(0, board.getSize());
            int random_col = random.nextInt(0, board.getSize());
            if (board.putMark(mark, random_row, random_col)) {
                break;
//                System.out.println(Constants.OCCUPIED_COORDINATE);

            }

        }

    }

}
