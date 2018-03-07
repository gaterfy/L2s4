package image;

import image.*;
import image.color.*;
import java.util.*;

/**
 * ImageMain class : a class that uses an example of an image
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class ImageMain {
  public static void usage() {
      System.out.println("usage: java -jar image.jar <pathToFile> <threshold> <nbGrayLevel>");
      System.exit(0);
  }
    public static void main(String[] args) {
      if (args.length != 3) {
        usage();
      } else {
        String pathToFile = args[0];
        int threshold = Integer.parseInt(args[1]);
        int nbGrayLevel = Integer.parseInt(args[2]);
        Image pgm = Image.initImagePGM(pathToFile);
        Image pgm2 = Image.initImagePGM(pathToFile);
        ImageDisplayer imgDisplay = new ImageDisplayer();
        imgDisplay.display(pgm, "Original Image");

        Image pgmEdges = pgm.edges(threshold);
        imgDisplay.display(pgmEdges, "Edge Image");

        Image pgmGrayDecreased = pgm2.decreaseNbGrayLevels(nbGrayLevel);
        imgDisplay.display(pgmGrayDecreased, nbGrayLevel + " Gray Image");
      }
    }
}
