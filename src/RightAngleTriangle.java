public class RightAngleTriangle extends Shape {
    public RightAngleTriangle() {
        maxHeight = 0;
        maxWidth = 0;
    }

    public RightAngleTriangle(int base, int height) {
        this.maxHeight = height;
        this.maxWidth = base;
    }

    public double getHeight() {
        return maxHeight;
    }

    public double getWidth() {
        return maxWidth;
    }

    public double perimeter() {
        return maxWidth + maxHeight + Math.sqrt(maxWidth * maxWidth + maxHeight * maxHeight);
    }

    public double area() {
        return (double)(maxWidth * maxHeight / 2);
    }

    //is it i or i+1
    @Override
    public String toString() {
        String res = "";
        for (int i = 1; i < maxHeight; i++) {
            res += " ";
            res += "* ".repeat((int)(i * maxWidth / maxHeight));
            res += "  ".repeat((int)(maxWidth - i * maxWidth / maxHeight));
            res += "\n ";
        }
        return res;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof RightAngleTriangle) {
            return maxWidth == ((RightAngleTriangle) other).maxWidth &&
                    maxHeight == ((RightAngleTriangle) other).maxHeight &&
                    this.perimeter() == ((RightAngleTriangle) other).perimeter();
        }
        return false;
    }
}
