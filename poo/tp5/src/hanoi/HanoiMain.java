package hanoi;

import hanoi.util.*;
import hanoi.*;
import hanoi.io.*;

/**
 * hanoiMain class : solves the hanoi towers problem
 *
 * @author : LOMBART Thomas - VASILEV Martin
 */

public class HanoiMain {

    /**
     * Usage for the hanoi game
     */
    public static void usage() {
        System.out.println("usage: java HanoiMain <nbDiscs>");
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
        } else {
            int capacity = Integer.parseInt(args[0]);
            Hanoi game = new Hanoi(capacity);
            game.solve(capacity, 0, 1, 2);
        }
    }
}
