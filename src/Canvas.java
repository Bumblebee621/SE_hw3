import java.util.Arrays;

public class Canvas {
    private Shape[][] canvas;
    private final int height;
    private final int width;
    private int[] maxWidthAtEachColumn;
    private int[] maxHieghtAtEachRow;
    public Canvas(int width, int height) {
        canvas = new Shape[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = null;
            }
        }
        this.height = height;
        this.width = width;
        maxWidthAtEachColumn = new int[width];
        Arrays.fill(maxWidthAtEachColumn, 0);
        maxWidthAtEachColumn = new int[height];
        Arrays.fill(maxWidthAtEachColumn, 0);
        //is [width][height] the right order
    }
    public void addShape(Shape shape, int x, int y) {
        canvas[x][y] = shape;
        if (shape.getWidth() > maxWidthAtEachColumn[x]) {
            maxWidthAtEachColumn[x] = (int)shape.getWidth();
        }
        if (shape.getHeight() > maxHieghtAtEachRow[y]) {
            maxHieghtAtEachRow[y] = (int)shape.getHeight();
        }
    }
    public void removeShape(int x, int y) {
        if(canvas[x][y].getWidth() == maxWidthAtEachColumn[x]){
            //here i need to find the max width after it
        }
        canvas[x][y] = null;

    }
    public double getTotalPerimeter() {
        double res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] != null) {
                    res += canvas[i][j].perimeter();
                }
            }
        }
        return res;
    }

    public double getTotalArea() {
        double res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] != null) {
                    res += canvas[i][j].area();
                }
            }
        }
        return res;
    }
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (canvas[i][j] != null) {
                    res += canvas[i][j].toString();
                } else {
                    res += "   ";
                }
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Canvas)) {
            return false;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!canvas[i][j].equals(obj)) {
                        return false;
                }
            }
        }
        return true;
    }
}
