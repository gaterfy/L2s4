package rps.strategy;

import rps.*;
import util.*;
import java.io.IOException;


/**
 * Class that can defines the *PlayerInput* strategy, meaning that a physical player will be asked to manually chose a shape, during the game a message will be printed asking for the players choice
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PlayerInputStrategy implements Strategy {

    /**
     * Constructer for the *PlayerInputStrategy* (does nothing)
     */
    public PlayerInputStrategy() {};

    /**
     * Method for the Strategy interface, allows the player to choose a shape that will be played
     * @return The chosen shape
     */
    public Shape chooseShape() {
        int answer = -1;
        System.out.println("Enter the number of the shape you want to play:\n1. ROCK\n2. PAPER\n3. SCISSORS");
        while (answer < 1 || answer > 3) {
            try {
                answer = Input.readInt();
            } catch (java.io.IOException e) {}
        }
        return Shape.values()[answer-1];
    }
}
