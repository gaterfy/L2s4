package rps;

import rps.strategy.*;

/**
 * Player Class : represents a player
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Player {
    /** The first player */
    private int score;
    /** The second player */
    private String name;
    /** Number of rounds */
    private Strategy strategy;

    /**
     * Creates a game defined by its player1, player2 and its number of rounds
     * @param name the name of the player
     * @param strategy the strategy of the player
     */
    public Player(String name, Strategy strategy) {
        this.score = 0;
        this.name = name;
        this.strategy = strategy;
    }

    /**
     * Gets the current score of this player
     * @return the score of the player
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Gets the name of this player
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Represents the player
     * @return a string representing the player
     */
    public String toString() {
        return this.name + " has " + this.score + " points ";
    }

    /**
     * Add points to the score of this player
     * @param nb the number of points to add to the score of this player
     */
    public void addScore(int nb) {
        this.score += nb;
    }

    /**
     * Plays a shape
     * @return the Shape that this player plays
     */
    public Shape play() {
        return this.strategy.chooseShape();
    }
}
