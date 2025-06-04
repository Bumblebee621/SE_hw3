import java.util.Arrays;

public class Canvas {
    private Shape[][] canvas;
    private final int height;
    private final int width;
    private int widestShape = 0;
    private int tallestShape = 0;

    /**
     * Constructs a new Canvas of specified width and height.
     *
     * @param width  the width of the canvas in terms of columns.
     * @param height the height of the canvas in terms of rows.
     */
    public Canvas(int height, int width) {
        canvas = new Shape[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = null;
            }
        }
        this.height = height;
        this.width = width;
        //is [width][height] the right order
    }

    /**
     * Adds a Shape object to the canvas at the specified coordinates.
     * The method updates the widest and tallest shapes on the canvas if the added shape exceeds the current dimensions.
     *
     * @param shape The Shape object to be added to the canvas.
     * @param x     The x-coordinate on the canvas where the shape will be placed.
     * @param y     The y-coordinate on the canvas where the shape will be placed.
     */
    public void addShape(Shape shape, int y, int x) {
        canvas[y][x] = shape;
        if (shape.getWidth() > widestShape) {
            widestShape = shape.getWidth();
        }
        if (shape.getHeight() > tallestShape) {
            tallestShape = shape.getHeight();
        }
    }

    /**
     * Removes the shape at the specified coordinates from the canvas.
     * If the removed shape's dimensions match the currently recorded widest or tallest shape,
     * the method recalculates the canvas-wide dimensions accordingly.
     *
     * @param x the x-coordinate of the shape to remove
     * @param y the y-coordinate of the shape to remove
     */
    public void removeShape(int x, int y) {
        if (canvas[y][x] == null) {
            return;
        }
        int removedShapeHeight = canvas[y][x].getHeight();
        int removedShapeWidth = canvas[y][x].getWidth();
        canvas[y][x] = null;
        int newMax = 0;
        if (removedShapeWidth == widestShape) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (canvas[i][j] != null && newMax < canvas[i][j].getWidth()) {
                        newMax = canvas[i][j].getWidth();
                    }
                }
            }
            widestShape = newMax;
            newMax = 0;
        }
        if (removedShapeHeight == tallestShape) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (canvas[i][j] != null && newMax < canvas[i][j].getHeight()) {
                        newMax = canvas[i][j].getHeight();
                    }
                }
            }
            tallestShape = newMax;
        }
    }

    /**
     * Calculates the total perimeter of all the shapes present in the canvas.
     * Iterates through each cell in a 2D array representing the canvas, checking if a
     * shape exists in each cell. If a shape is present, its perimeter is added to the total.
     *
     * @return the sum of the perimeters of all shapes in the canvas as a double value.
     */
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

    /**
     * Calculates the total area of all shapes present on the canvas.
     * Iterates over the 2D array of shapes and sums up the area of each non-null shape.
     *
     * @return the total area of all shapes on the canvas as a double value
     */
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
    /**
     * Generates a string representation of the Canvas object.
     * The representation includes all shapes placed on the canvas in their respective positions.
     * Empty spaces on the canvas are filled with whitespace to maintain alignment.
     *
     * @return A string representing the current state of the canvas,
     *         with shapes rendered as defined by their respective toString implementations.
     */
    /**
     * Print the canvas “column by column” (i.e. transposed on the y = x axis),
     * but still in a grid:
     * – Each original column c (c = 0..width-1) becomes a “printed row.”
     * – Within that printed row, you walk across r = 0..height-1 as columns.
     * – You pad every shape (or null‐cell) to the same global widestShape width.
     * – Three spaces "   " separate columns.
     * – After printing all lines for one column‐row, you add a blank line.
     */
    @Override
    public String toString() {
        String res = "";
        for(int j = 0; j < height; j++){
            int tallestShapeInThisLine = 0;
            for(int i = 0; i < width; i++){
                if(canvas[j][i] != null && canvas[j][i].getHeight() > tallestShapeInThisLine){
                    tallestShapeInThisLine = canvas[j][i].getHeight();
                }
            }
            if(tallestShapeInThisLine > 0){
                for(int k = 0; k < tallestShapeInThisLine; k++){
                    //razh al hashoorot shel shoora spetzifit bakanvas
                    for(int h = 0; h < width; h++){

                        if(canvas[j][h] != null){
                            res += canvas[j][h].toStringLine(k, widestShape);
                        }
                        else{
                            res += "   ".repeat(widestShape);
                        }
                        if(h < width - 1){
                            res += "   ";
                        }
                    }
                    res += "\n";
                }
            }
            res += "\n";
        }
        return res;
    }

    /*@Override
    public String toString() {
        StringBuilder[][] temp = new StringBuilder[height][width];
        StringBuilder res = new StringBuilder();
        //init an array of stringbuilders containing each shape toString
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] != null) {
                    temp[i][j] = new StringBuilder(canvas[i][j].toString());
                } else {
                    temp[i][j] = new StringBuilder();
                }
            }
        }

        for (int i = 0; i < height; i++) {
            res.append(concateOneLine(canvas[i], temp[i]));
            res.append("\n");
        }

        return res.toString();
    }

    private StringBuilder concateOneLine(Shape[] oneLine, StringBuilder[] sb) {
        StringBuilder res = new StringBuilder();

        //look for tallest shape in this line
        int tallestShapeInThisLine = 0;
        for (int i = 0; i < width; i++) {
            if (oneLine[i] != null && oneLine[i].getHeight() > tallestShapeInThisLine) {
                tallestShapeInThisLine = oneLine[i].getHeight();
            }
        }
        for (int k = 0; k < tallestShapeInThisLine; k++) {
            for (int j = 0; j < width; j++) {

                if (sb[j].length() != 0 && oneLine[j] != null) {
                    res.append(sb[j], 0, oneLine[j].getWidth() * 3);
                    int remainingSpaces = widestShape - oneLine[j].getWidth();
                    res.append(" ".repeat(3 * (Math.max(remainingSpaces, 0))));
                    sb[j].delete(0, oneLine[j].getWidth() * 3 + 1);
                } else {
                    sb[j].append("   ".repeat(widestShape));
                }
                res.append(" ".repeat(3));
            }
            res.append("\n");
        }
        return res;
    }*/

    /**
     * Compares the current Canvas object with the specified object for equality.
     * Two Canvas instances are considered equal if they have the same dimensions
     * and all corresponding elements within their 2D arrays are equal.
     *
     * @param obj the object to be compared with this Canvas instance.
     * @return true if the specified object is equal to this Canvas, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Canvas other)) {
            return false;
        }

        if (height != other.height || width != other.width) {
            return false;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] == null && other.canvas[i][j] == null) {
                    continue;
                }
                if (canvas[i][j] == null || other.canvas[i][j] == null || !canvas[i][j].equals(other.canvas[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}