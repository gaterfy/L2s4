package image;

import image.*;
import image.color.*;
import java.util.*;

/**
 * ImageExample class : a class that uses an example of an image
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class ImageExample {
    public static void main(String[] args) {
        Image img = new Image(100, 200);
        Pixel blackPixel = new Pixel(GrayColor.BLACK);
        for (int x = 10; x < 30; x++) {
            for (int y = 30; y < 60; y++) {
                img.setPixel(x, y, blackPixel);
            }
        }

        Pixel gray64Pixel = new Pixel(new GrayColor(64));
        for (int x = 50; x < 70; x++) {
            for (int y = 50; y < 100; y++) {
                img.setPixel(x, y, gray64Pixel);
            }
        }

        Pixel gray230Pixel = new Pixel(new GrayColor(230));
        for (int x = 20; x < 40; x++) {
            for (int y = 110; y < 160; y++) {
                img.setPixel(x, y, gray230Pixel);
            }
        }

        ImageDisplayer imgDisplay = new ImageDisplayer();
        imgDisplay.display(img, "Original Image");

        Image imgEdges = img.edges(5);
        imgDisplay.display(imgEdges, "Edge Image");
    }
}
