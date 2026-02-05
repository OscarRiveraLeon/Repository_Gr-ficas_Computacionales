package images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Solecito {
    public static void main(String[] args) {
        int width = 600;
        int height = 600;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int sunCenterX = 250;
        int sunCenterY = 200;
        int sunRadius = 60;
        int sunRadiusSquared = sunRadius * sunRadius;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                double dx = x - sunCenterX;
                double dy = y - sunCenterY;
                double distSquared = (dx * dx) + (dy * dy);
                double angle = Math.toDegrees(Math.atan2(dy, dx));
                if (angle < 0) angle += 360;

                int grassY = (int) (400 + Math.sin(x / 20.0) * 10);

                if (distSquared < sunRadiusSquared) {
                    img.setRGB(x, y, Color.YELLOW.getRGB());
                }
                else if (distSquared < 18000 && Math.round(angle) % 45 == 0) {
                    img.setRGB(x, y, Color.RED.getRGB());
                }
                else if (y > grassY) {
                    img.setRGB(x, y, new Color(50, 180, 50).getRGB());
                }
                else {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }

        JFrame frame = new JFrame("Drawing-Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}