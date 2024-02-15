public class MyOwnAutoShop {
    //Problema auto 
    public static void main(String[] args) {
        Ford ford1 = new Ford(70, 30000.0, "Silver", 1500);
        Ford ford2 = new Ford(75, 35000.0, "Black", 2000);

        Sedan sedan = new Sedan(50, 20000.0, "Green", 18);

        Car genericCar = new Car(60, 20000.0, "Blue");

        System.out.println("Sale Price for Ford 1: $" + ford1.getSalePrice());
        System.out.println("Sale Price for Ford 2: $" + ford2.getSalePrice());
        System.out.println("Sale Price for Sedan: $" + sedan.getSalePrice());
        System.out.println("Sale Price for Generic Car: $" + genericCar.getSalePrice());
    }
}