public class Truck extends Car {
        private int weight;

        public Truck(int speed, double regularPrice, String color, int weight) {
            super(speed, regularPrice, color);
            this.weight = weight;
        }

        @Override
        public double getSalePrice() {
            if (weight > 2000) {
                return 0.80 * super.getRegularPrice(); // 20% discount
            } else {
                return 0.90 * super.getRegularPrice(); // 10% discount
            }
        }
}