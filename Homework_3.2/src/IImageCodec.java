import java.awt.image.BufferedImage;

public interface IImageCodec {
    byte[][][] compress(BufferedImage image);
    BufferedImage decompress(byte[][][] data);
}