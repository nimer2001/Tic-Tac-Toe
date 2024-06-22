/**
 * this class represents the board
 */
public class Board {
    Mark[][] board;
    private final int board_length;
    public final static int DEFAULT_BOARD_SIZE = 4;

    /**
     * a default constructor
     */
    public Board() {
        this.board_length = DEFAULT_BOARD_SIZE;
        this.board = new Mark[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * a constructor
     * @param size the size of the board
     */
    public Board(int size) {
        this.board = new Mark[size][size];
        this.board_length = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     *
     * @return the size of the board
     */
    public int getSize() {
        return this.board_length;
    }

    /**
     * this function puts a mark on the board
     * @param mark a mark
     * @param row an int represent a row
     * @param col an int represent a col
     * @return true if we put the mark successfully
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (row >= this.board_length || row < 0 || col >= this.board_length || col < 0) {
            return false;
        }
        if (this.board[row][col] == Mark.BLANK) {
            this.board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     *
     * @param row an int represent a row
     * @param col an int represent a col
     * @return the mark in the place[row][col]
     */
    public Mark getMark(int row, int col) {
        if (row >= this.board_length || row < 0 || col >= this.board_length || col < 0) {
            return Mark.BLANK;
        }
        return this.board[row][col];
    }
}
