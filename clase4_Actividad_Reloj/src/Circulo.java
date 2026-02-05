package images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Circulo {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int centerX = width / 2;
        int centerY = height / 2;
        int radius = 100;
        int radiusSquared = radius * radius;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double dx = x - centerX;
                double dy = y - centerY;
                double distanceSquared = Math.pow(dx, 2) + Math.pow(dy, 2);
                double angleDegrees = Math.toDegrees(Math.atan2(dy, dx));

                if (angleDegrees < 0) angleDegrees += 360;
                long roundedAngle = Math.round(angleDegrees);

                if (distanceSquared > 9500 && distanceSquared < 10500) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
                else if (roundedAngle == 270 && distanceSquared < radiusSquared) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
                else if (roundedAngle == 0 && distanceSquared < 4900) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
                else if (distanceSquared > 9000 && distanceSquared < 11000 && roundedAngle % 30 == 0) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
                else {
                    img.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        JFrame frame = new JFrame("Java Clock Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}