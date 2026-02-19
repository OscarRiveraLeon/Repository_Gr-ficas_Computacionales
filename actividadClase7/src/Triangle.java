class Triangle {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getPixelColor(int x, int y) {
        double det = (b.y - c.y) * (a.x - c.x) + (c.x - b.x) * (a.y - c.y);
        double l1 = ((b.y - c.y) * (x - c.x) + (c.x - b.x) * (y - c.y)) / det;
        double l2 = ((c.y - a.y) * (x - c.x) + (a.x - c.x) * (y - c.y)) / det;
        double l3 = 1.0 - l1 - l2;

        if (l1 >= 0 && l2 >= 0 && l3 >= 0) {
            int red = (int) (l1 * a.r + l2 * b.r + l3 * c.r);
            int green = (int) (l1 * a.g + l2 * b.g + l3 * c.g);
            int blue = (int) (l1 * a.b + l2 * b.b + l3 * c.b);
            return (red << 16) | (green << 8) | blue;
        }
        return 0xFFFFFF;
    }
}