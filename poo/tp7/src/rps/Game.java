package rps;

/**
 * Game class : represents a game
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Game {
    /** The first player */
    private Player player1;
    /** The second player */
    private Player player2;
    /** Number of rounds */
    private int nbRounds;

    /**
     * Creates a game defined by its player1, player2 and its number of rounds
     * @param player1 the first player
     * @param player2 the second player
     * @param nbRounds the number of rounds
     */
    public Game(Player player1, Player player2, int nbRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.nbRounds = nbRounds;
    }

    /**
     * Give points to players
     * @param result the result of the comparison between the two shapes
     */
    public void givePoints(int result) {
        if (result < 0) {
            this.player2.addScore(2);
            System.out.println("Player 2 wins this round!\n");
        } else if (result > 0) {
            this.player1.addScore(2);
            System.out.println("Player 1 wins this round!\n");
        } else {
            this.player1.addScore(1);
            this.player2.addScore(1);
            System.out.println("It's a draw !\n");

        }
    }

    /**
     * Plays one round
     */
    public void playOneRound() {
        Shape s1 = this.player1.play();
        Shape s2 = this.player2.play();
        System.out.println(this.player1.getName() + " plays " + s1);
        System.out.println(this.player2.getName() + " plays " + s2 + "\n");
        int result = s1.compareShape(s2);
        this.givePoints(result);
        System.out.println(this.player1);
        System.out.println(this.player2 + "\n");
    }

    /**
     * Plays one whole game
     */
    public void playGame() {
      System.out.println("LET'S PLAY\n");
        for (int round = 0; round < this.nbRounds; round++) {
            System.out.println("Round " + (round + 1) + "\n");
            this.playOneRound();
        }
    }
}
