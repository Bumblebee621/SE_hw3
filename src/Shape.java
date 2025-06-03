    public abstract class Shape {
        protected int maxWidth;
        protected int maxHeight;

        public abstract double area();

        public abstract double perimeter();

        public abstract double getWidth();

        public abstract double getHeight();

        @Override
        public abstract String toString();
        @Override
        public abstract boolean equals(Object obj);

    }
