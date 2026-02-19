import java.awt.Color;
import java.awt.image.BufferedImage;

public class BlockAverageCodec implements IImageCodec {
    private final int blockSize;

    public BlockAverageCodec(int blockSize) {
        this.blockSize = blockSize;
    }

    @Override
    public byte[][][] compress(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int compWidth = width / blockSize;
        int compHeight = height / blockSize;

        byte[][][] compressed = new byte[compHeight][compWidth][3];

        for (int y = 0; y < compHeight; y++) {
            for (int x = 0; x < compWidth; x++) {
                compressed[y][x] = calculateAverage(image, x * blockSize, y * blockSize);
            }
        }
        return compressed;
    }

    private byte[] calculateAverage(BufferedImage img, int startX, int startY) {
        long r = 0, g = 0, b = 0;
        int count = 0;

        for (int y = startY; y < startY + blockSize && y < img.getHeight(); y++) {
            for (int x = startX; x < startX + blockSize && x < img.getWidth(); x++) {
                Color c = new Color(img.getRGB(x, y));
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
                count++;
            }
        }
        return new byte[] { (byte)(r/count), (byte)(g/count), (byte)(b/count) };
    }

    @Override
    public BufferedImage decompress(byte[][][] data) {
        int height = data.length * blockSize;
        int width = data[0].length * blockSize;
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data[0].length; x++) {
                int r = data[y][x][0] & 0xFF;
                int g = data[y][x][1] & 0xFF;
                int b = data[y][x][2] & 0xFF;
                int rgb = new Color(r, g, b).getRGB();
                applyBlock(output, x * blockSize, y * blockSize, rgb);
            }
        }
        return output;
    }

    private void applyBlock(BufferedImage img, int startX, int startY, int rgb) {
        for (int y = startY; y < startY + blockSize; y++) {
            for (int x = startX; x < startX + blockSize; x++) {
                if (x < img.getWidth() && y < img.getHeight()) {
                    img.setRGB(x, y, rgb);
                }
            }
        }
    }
}