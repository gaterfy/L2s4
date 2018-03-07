package rps;

import rps.strategy.*;
import util.*;

/**
 * Class that allows playing of the Rock-Paper-Scissors game
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class GameMain {

    public GameMain() {}

    /**
     * Displays the usage
     */
    public static void usage() {
        System.out.println("usage: java -jar rps.jar\nYou will be asked how the game should be played in consequence!");
        System.exit(0);
    }

    /**
     * Choose the game mode
     * @return the game mode chosen
     */
    public static int chooseGameMode() {
        int gameMode = -1;
        System.out.println("Game modes (Type in the number infront of a gamemode to select it!) :\n1. Choose both strategies\n2. One is a PlayerInput strategy and the other is random");
        try {
            while (gameMode < 1 || gameMode > 2)
                gameMode = Input.readInt();
        } catch (Exception e) {}
        return gameMode;
    }

    /**
     * Choose the name of the player
     * @param playerNumber the number of the player
     * @return the name of the player
     */
    public static String chooseName(int playerNumber) {
        System.out.println("What's the name of player " + playerNumber + " : ");
        return Input.readString();
    }

    /**
     * Choose the strategy of the player
     * @param namePlayer the name of the player
     * @return the strategy chosen
     */
    public static Strategy chooseStrategy(String namePlayer) {
        int strategy = -1;
        System.out.println(namePlayer + ", choose your strategy :\n1. Always choose paper\n2. Permute shapes\n3. I want to choose my shape every round\n4. Random shapes");
        try {
            while (strategy < 1 || strategy > 4)
                strategy = Input.readInt();
        } catch (Exception e) {}

        switch (strategy) {
            case 1:
                return new PaperStrategy();
            case 2:
                return new PermuteStrategy();
            case 3:
                return new PlayerInputStrategy();
            case 4:
                return new RandomStrategy();
            default:
                return new RandomStrategy();
        }

    }

    public static void main(String[] args) {
        if (args.length != 0)
            usage();
        else {
            System.out.println("ROCK/PAPER/SCISSORS Game\n");
            String namePlayer1 = chooseName(1);
            String namePlayer2 = chooseName(2);
            System.out.println();
            int gameMode = chooseGameMode();
            Player p1;
            Player p2;
            if (gameMode == 1) {
                p1 = new Player(namePlayer1, chooseStrategy(namePlayer1));
                p2 = new Player(namePlayer2, chooseStrategy(namePlayer2));
            }  else {
                p1 = new Player(namePlayer1, new PlayerInputStrategy());
                p2 = new Player(namePlayer2, new RandomStrategy());
            }
            Game rps = new Game(p1, p2, 5);
            rps.playGame();

            if (p1.getScore() > p2.getScore()) {
                System.out.println(p1.getName() + " wins the game");
            } else if (p1.getScore() < p2.getScore()) {
                System.out.println(p2.getName() + " wins the game");
            } else {
                System.out.println("It's a draw!");
            }
        }
    }
}
