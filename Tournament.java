/**
 * This class runs a tournament
 */
public class Tournament {
    private Player player1;
    private Player player2;
    private int rounds;
    private Renderer renderer;
    private Game game;

    /**
     * The constructor of the tournament class
     *
     * @param rounds   number of rounds in the tournament
     * @param renderer a renderer to represent the board
     * @param player1  a player(could be a genius,clever,whatever,human)
     * @param player2  a player(could be a genius,clever,whatever,human)
     */
    public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
        this.rounds = rounds;
        this.player1 = player1;
        this.player2 = player2;
        this.renderer = renderer;
    }

    /**
     * this function plays the game rounds times
     *
     * @param size        the size of the board
     * @param winStreak   the win streak to win the game
     * @param playerName1 a player(could be a genius,clever,whatever,human)
     * @param playerName2 a player(could be a genius,clever,whatever,human)
     */
    public void playTournament(int size, int winStreak, String playerName1, String playerName2) {
        int i = 0;
        Mark x_mark = Mark.X;
        Mark o_mark = Mark.O;
        int num_of_win_player1 = 0;
        int num_of_win_player2 = 0;
        int num_of_draws = 0;
        while (i < this.rounds) {
            if (i % 2 == 0) {
                game = new Game(this.player1, this.player2, size, winStreak, this.renderer);
                Mark last_Mark = game.run();
                if (last_Mark == x_mark) {
                    num_of_win_player1++;
                } else if (last_Mark == o_mark) {
                    num_of_win_player2++;
                } else if (last_Mark == Mark.BLANK) {
                    num_of_draws++;
                }
            } else {
                game = new Game(this.player2, this.player1, size, winStreak, this.renderer);
                Mark last_Mark = game.run();
                if (last_Mark == x_mark) {
                    num_of_win_player2++;
                } else if (last_Mark == o_mark) {
                    num_of_win_player1++;
                } else if (last_Mark == Mark.BLANK) {
                    num_of_draws++;
                }
            }
            i++;
        }

        System.out.println("######### Results #########  ");
        System.out.println("Player 1, " + playerName1.toLowerCase() + " won: "
                + num_of_win_player1 + " rounds");
        System.out.println("Player 2, " + playerName2.toLowerCase() + " won: "
                + num_of_win_player2 + " rounds");
        System.out.println("Ties: " + num_of_draws);
    }

    /**
     * this function check the parameters given from the command line argument
     *
     * @param first_player_name  a string
     * @param second_player_name a string
     * @param renderer_name      a string
     * @return true if the parameters are right,false otherwise
     */
    private static boolean[] check_parameters(String first_player_name
            , String second_player_name, String renderer_name) {
        boolean correct_first_player = false;
        boolean correct_second_player = false;
        boolean correct_renderer = false;
        for (int i = 0; i < Constants.LEGAL_PLAYERS.length; i++) {
            if (first_player_name.equalsIgnoreCase(Constants.LEGAL_PLAYERS[i])) {
                correct_first_player = true;
            }
            if (second_player_name.equalsIgnoreCase(Constants.LEGAL_PLAYERS[i])) {
                correct_second_player = true;
            }
        }
        for (int i = 0; i < Constants.LEGAL_RENDERERS.length; i++) {
            if (renderer_name.equalsIgnoreCase(Constants.LEGAL_RENDERERS[i])) {
                correct_renderer = true;
            }
        }

        return new boolean[]{correct_first_player && correct_second_player, correct_renderer};
    }

    /**
     * this is the main function,it runs the program
     *
     * @param args the args from command line arguments
     */
    public static void main(String[] args) {

        boolean[] check_p = check_parameters(args[4], args[5], args[3]);
        if (!check_p[1]) {
            System.out.println(Constants.UNKNOWN_RENDERER_NAME);
            return;
        }
        if (!check_p[0]) {
            System.out.println(Constants.UNKNOWN_PLAYER_NAME);
            return;
        }
        PlayerFactory pf = new PlayerFactory();
        RendererFactory rf = new RendererFactory();
        Renderer renderer = rf.buildRenderer(args[3], Integer.parseInt(args[1]));
        Player player1 = pf.buildPlayer(args[4]);
        Player player2 = pf.buildPlayer(args[5]);
        Tournament t = new Tournament(Integer.parseInt(args[0]), renderer, player1, player2);
        t.playTournament(Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[4], args[5]);
    }
}
