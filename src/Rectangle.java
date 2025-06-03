public class Rectangle extends Shape {
    public Rectangle() {
        maxHeight = 0;
        maxWidth = 0;
    }

    public Rectangle(int width, int height) {
        this.maxHeight = height;
        this.maxWidth = width;
    }

    public double getHeight() {
        return maxHeight;
    }

    public double getWidth() {
        return maxWidth;
    }

    public double perimeter() {
        return 2*maxWidth + 2*maxHeight;
    }

    public double area() {
        return maxWidth * maxHeight;
    }

    //is it i or i+1
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < maxHeight; i++) {
                res += " ";
                res += "* ".repeat(maxWidth);
                res += "\n ";
        }
        return res;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Rectangle) {
            return maxWidth == ((Rectangle) other).maxWidth &&
                    maxHeight == ((Rectangle) other).maxHeight;
        }
        return false;
    }
}
