import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Desktop;

public class WebRenderer {
    public static void main(String[] args) {
        int size = 600;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        Point p1 = new Point(300, 50, 0, 0, 255);
        Point p2 = new Point(50, 550, 255, 0, 0);
        Point p3 = new Point(550, 550, 0, 255, 0);

        Triangle triangle = new Triangle(p1, p2, p3);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                image.setRGB(x, y, triangle.getPixelColor(x, y));
            }
        }

        try {
            File outputFile = new File("triangle.png");
            ImageIO.write(image, "png", outputFile);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(outputFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}