package images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Triangulos {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x > y) {
                    img.setRGB(x, y, Color.red.getRGB());
                } else {
                    img.setRGB(x, y, Color.blue.getRGB());
                }
            }
        }

        try {
            File outputImage = new File("image.jpg");
            ImageIO.write(img, "jpg", outputImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Visualizador de Imagen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon(img));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}