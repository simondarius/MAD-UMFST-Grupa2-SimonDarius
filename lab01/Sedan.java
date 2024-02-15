public class Sedan extends Car {
        private int length;

        public Sedan(int speed, double regularPrice, String color, int length) {
            super(speed, regularPrice, color);
            this.length = length;
        }

        @Override
        public double getSalePrice() {
            if (length < 20) {
                return 0.90 * super.getRegularPrice(); // 10% discount
            } else {
                return 0.95 * super.getRegularPrice(); // 5% discount
            }
        }
    }