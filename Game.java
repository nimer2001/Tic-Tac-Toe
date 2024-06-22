/**
 * this class represents the game
 */
public class Game {
    Player px;
    Player po;
    Renderer r;
    private int winStreak;
    private Board board;

    /**
     * this constructor is a default constructor
     * @param playerX a player
     * @param playerO a player
     * @param renderer a renderer
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.r = renderer;
        this.px = playerX;
        this.po = playerO;
        this.winStreak = 3;
        this.board = new Board();
    }

    /**
     * a second constructor
     * @param playerX a player
     * @param playerY a player
     * @param size the size of the board
     * @param winStreak the win streak
     * @param renderer a renderer
     */
    public Game(Player playerX, Player playerY, int size, int winStreak, Renderer renderer) {
        this.board = new Board(size);
        this.winStreak = winStreak;
        this.px = playerX;
        this.po = playerY;
        this.r = renderer;
        if (winStreak > size) {
            this.winStreak = size;
        }


    }

    /**
     *
     * @return the win streak
     */
    public int getWinStreak() {
        return this.winStreak;
    }

    /**
     *
     * @return return the board size
     */
    public int getBoardSize() {
        return board.getSize();
    }

    /**
     * this function checks if the values of the giving list are all the same.
     * @param m a list of marks
     * @return true if the values are the same,false otherwise
     */
    private boolean checkIfValuesTheSame(Mark[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != m[0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * this function checks if the board is empty
     * @param b a board
     * @return true if the board is not empty
     */
    private boolean checkIfBoardIsNotEmpty(Board b) {

        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                if (b.getMark(i, j) == Mark.BLANK) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks if there is a winner while checking the rows
     * @param b a board
     * @return a true if there is a winner
     */
    private boolean checkIfGameOverFromLeft(Board b) {
        Mark[] route = new Mark[this.winStreak];
        for (int row = 0; row <= b.getSize(); row++) {
            for (int col = 0; col <= b.getSize() - winStreak; col++) {
                for (int k = 0; k < winStreak; k++) {
                    route[k] = board.getMark(row, k + col);
                }
                if (checkIfValuesTheSame(route) && route[0] != Mark.BLANK) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * checks if there is a winner while checking the cols
     * @param b a board
     * @return a true if there is a winner
     */
    private boolean checkIfGameOverFromDown(Board b) {
        Mark[] route = new Mark[this.winStreak];
        for (int col = 0; col <= b.getSize(); col++) {
            for (int row = 0; row <= b.getSize() - winStreak; row++) {
                for (int k = 0; k < this.winStreak; k++) {
                    route[k] = board.getMark(row + k, col);
                }
                if (checkIfValuesTheSame(route) && route[0] != Mark.BLANK) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * checks if there is a winner while checking the diagonals
     * @param b a board
     * @return true if there is a winner
     */
    private boolean checkIfGameOverFromDiagonal(Board b) {
        Mark[] route = new Mark[winStreak];
        // Iterate through diagonals from bottom-left to top-right
        for (int i = b.getSize() - 1; i >= winStreak - 1; i--) {
            for (int j = 0; j <= b.getSize() - winStreak; j++) {
                for (int k = 0; k < winStreak; k++) {
                    route[k] = b.getMark(i - k, j + k);
                }
                if (checkIfValuesTheSame(route) && route[0] != Mark.BLANK) {
                    return true;
                }
            }
        }
        // Check diagonals from top-left to bottom-right
        for (int i = 0; i <= b.getSize() - winStreak; i++) {
            for (int j = 0; j <= b.getSize() - winStreak; j++) {
                for (int k = 0; k < winStreak; k++) {
                    route[k] = b.getMark(i + k, j + k);
                }
                if (checkIfValuesTheSame(route) && route[0] != Mark.BLANK) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this function checks if there is a winner
     * @param b a board
     * @return true if there is a winner
     */
    private boolean checkIfGameOver(Board b) {
        //from left
        if (checkIfGameOverFromLeft(b) ||
                checkIfGameOverFromDown(b) ||
                checkIfGameOverFromDiagonal(b)) {
            return true;
        }
        return false;


    }

    /**
     * this function runs a single game
     * @return the mark of the winning player,and blank if there is a tie.
     */
    public Mark run() {
        Mark player1Mark = Mark.X;
        Mark player2Mark = Mark.O;
        Mark winnerMark = Mark.X;
//    this.r.renderBoard(this.board);
        while (checkIfBoardIsNotEmpty(this.board) && !checkIfGameOver(this.board)) {
            if (!checkIfBoardIsNotEmpty(this.board)) {
                return Mark.BLANK;
            }
            this.px.playTurn(this.board, player1Mark);
            if (checkIfGameOver(this.board)) {
                winnerMark = player1Mark;
                this.r.renderBoard(this.board);
                return winnerMark;
            }
            this.r.renderBoard(this.board);
            if (!checkIfBoardIsNotEmpty(this.board)) {
                return Mark.BLANK;
            }
            this.po.playTurn(this.board, player2Mark);
            if (checkIfGameOver(this.board)) {
                winnerMark = player2Mark;
                this.r.renderBoard(this.board);
                return winnerMark;
            }
            this.r.renderBoard(this.board);
        }
        if (!checkIfBoardIsNotEmpty(this.board)) {
            return Mark.BLANK;
        }
        return winnerMark;
    }
}
