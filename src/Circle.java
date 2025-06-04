public class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
        this.maxHeight = 2 * radius + 1;
        this.maxWidth = 2 * radius + 1;
    }

    public Circle() {
        this(0);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public int getWidth() {
        return maxWidth;
    }

    public int getHeight() {
        return maxHeight;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        String finalShape = "";
        double distance;
        for (int i = 0; i <= maxHeight; i++) {
            for (int j = 0; j <= maxWidth; j++) {
                distance = Math.sqrt(((radius - j) * (radius - j)) + ((radius - i) * (radius - i)));
                if (distance <= radius + 0.3) {
                    finalShape += " * ";
                } else {
                    finalShape += "   ";
                }
            }
            finalShape += "\n";
        }
        return finalShape;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            if (((Circle) obj).radius == this.radius) {
                return true;
            }
            return false;
        }
        return false;
    }

}