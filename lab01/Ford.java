public class Ford extends Car {
        private int manufacturerDiscount;

        public Ford(int speed, double regularPrice, String color, int manufacturerDiscount) {
            super(speed, regularPrice, color);
            this.manufacturerDiscount = manufacturerDiscount;
        }

        @Override
        public double getSalePrice() {
            return super.getSalePrice() - manufacturerDiscount;
        }
    }