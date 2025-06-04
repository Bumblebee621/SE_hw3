    public abstract class Shape {
        protected int maxWidth;
        protected int maxHeight;

        public abstract double area();

        public abstract double perimeter();

        public abstract int getWidth();

        public abstract int getHeight();

        protected String toStringLine(int rowInShape, int widestShape){
                StringBuilder sb = new StringBuilder(this.toString());
                if(rowInShape > this.getHeight() - 1){
                        return "   ".repeat(widestShape);
                }
                for(int i = 0; i < rowInShape; i++){
                        sb.delete(0, sb.indexOf("\n") + 1);
                }
                String res = sb.substring(0, sb.indexOf("\n"));
                res += "   ".repeat(widestShape - this.getWidth());
                return res;
        }

        @Override
        public abstract String toString();
        @Override
        public abstract boolean equals(Object obj);

    }
