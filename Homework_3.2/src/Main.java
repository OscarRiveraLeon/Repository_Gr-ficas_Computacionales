import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.jpeg");
            BufferedImage sourceImage = ImageIO.read(inputFile);

            IImageCodec codec = new BlockAverageCodec(8);

            byte[][][] compressedData = codec.compress(sourceImage);
            BufferedImage resultImage = codec.decompress(compressedData);

            File outputFile = new File("output.jpg");
            ImageIO.write(resultImage, "jpg", outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}