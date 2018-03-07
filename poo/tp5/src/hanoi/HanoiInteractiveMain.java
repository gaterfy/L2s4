package hanoi;

import hanoi.util.*;
import hanoi.*;
import hanoi.io.*;

/**
 * hanoiMain class : solves the hanoi towers problem
 *
 * @author : LOMBART Thomas - VASILEV Martin
 */

public class HanoiInteractiveMain {

    /**
     * Usage for the hanoi game
     */
    public static void usage() {
        System.out.println("usage: java -jar appli.jar <nbDiscs>");
        System.exit(0);
    }

    /**
     * Prints out how to play the game
     */
    public static void instructions() {
        System.out.println("-------------------\nINSTRUCTIONS DE JEU\n-------------------\n");
        System.out.println("- Tour de gauche : g, tour du centre : c, tour de droite : d");
        System.out.println("- Pour effectuer un déplacement, tapez deux lettres : celle de la tour de départ et de la tour d'arrivée.");
        System.out.println("- Exemple : gc, déplace le disque du sommet de la tour gauche sur celui de la tour du centre.");
        System.out.println("- Vous pouvez quitter à tout moment en saisissant quit\n");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
        } else {
            try {
                int capacity = Integer.parseInt(args[0]);
                Hanoi game = new Hanoi(capacity);
                instructions();
                game.display();
                HanoiInput input = new HanoiInput();
                while (!game.isSolved()) {
                    input.readInput();
                    if (input.isMove())
                        if (game.isAllowed(input.getFrom(), input.getTo()))
                            game.moveOneDisc(input.getFrom(), input.getTo());
                        else
                            System.out.println("Ce déplacement n'est pas autorisé");
                    else {
                        System.out.println("Merci d'avoir joué à ce jeu, à bientôt!");
                        System.exit(0);
                    }
                }
                System.out.println("Vous avez réussi, félicitations!");
            } catch (Exception e) {}
        }
    }
}
