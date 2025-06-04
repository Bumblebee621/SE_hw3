public class RightAngleTriangle extends Shape {
    public RightAngleTriangle() {
        maxHeight = 0;
        maxWidth = 0;
    }

    public RightAngleTriangle(int base, int height) {
        this.maxHeight = height;
        this.maxWidth = base;
    }

    public int getHeight() {
        return maxHeight;
    }

    public int getWidth() {
        return maxWidth;
    }

    public double perimeter() {
        return maxWidth + maxHeight + Math.sqrt(maxWidth * maxWidth + maxHeight * maxHeight);
    }

    public double area() {
        return ((double)maxWidth * maxHeight / 2);
    }

    //is it i or i+1
    @Override
    public String toString() {
        String res = "";
        for (int i = 1; i <= maxHeight; i++) {
            int stars = ((int)((double)i*maxWidth/maxHeight));
            if(((double)i*maxWidth/maxHeight) > 0.5 && ((double)i*maxWidth/maxHeight) < 1.0){
                res += " * ";
            }
            else {
                res += " * ".repeat(stars);
            }
            res += "   ".repeat(maxWidth - stars);
//            double temp =  i * (double)maxWidth / (double)maxHeight;
//            if(temp % 1 > 0.5){
//                res += " * ".repeat((int)(temp) + 1);
//            }
//            else{
//                res += " * ".repeat((int)(temp));
//            }
//            res += "   ".repeat((int)(maxWidth - temp));
            res += "\n";
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
