package images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        //Img.setRGB(200, 200, Color.yellow.getRGB());
        int z;
        for (int x = 0; x < 400; x++) {

            for (int y = 0; y < 400; y++) {
                if (x > y) {
                    img.setRGB(x, y, Color.red.getRGB()); // Red
                } else {
                    img.setRGB(x, y, Color.blue.getRGB());
                }
            }
        }
        File outputImage = new File("image.jpg");
        try {
            ImageIO.write(img, "jpg", outputImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}