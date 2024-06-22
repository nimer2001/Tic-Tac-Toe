/**
 * this class represent a human
 */
public class HumanPlayer implements Player {
    /**
     * this is constructor
     */
    public HumanPlayer() {

    }

    /**
     * this function puts a mark on the board
     * @param board a board
     * @param mark a mark
     */
    public void playTurn(Board board, Mark mark) {
        System.out.println("Player " + mark + ",type coordinates: ");

        while (true) {
            int player_input = KeyboardInput.readInt();
            int player_row_input = player_input / 10;
            int player_column_input = player_input % 10;
            if (player_row_input >= board.getSize() || player_column_input >= board.getSize()) {
                System.out.print(Constants.INVALID_COORDINATE);
                continue;
            }
            if (!board.putMark(mark, player_row_input, player_column_input)) {
                System.out.print(Constants.OCCUPIED_COORDINATE);

            }
            else {
                break;
            }

        }
    }


}




