import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class lab1
{   public static void printPrimes(int maxValue) {
        List<int[]> twinPrimes = new ArrayList<>();

        for (int i = 3; i < maxValue; i += 2) {
            if (isPrime(i) && isPrime(i + 2)) {
                int[] twinPrimePair = {i, i + 2};
                twinPrimes.add(twinPrimePair);
            }
        }

        System.out.println("Twin Prime Pairs under " + maxValue + ":");
        for (int[] pair : twinPrimes) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
	    /*Problema 1
		Scanner scanner=new Scanner(System.in);
        int input = scanner.nextInt();
        if(input<0){
            System.out.println("Numar negativ");
        }else{
            System.out.println("Numar pozitiv");
        }
        scanner.close();*/
        /*Problema 2
        int[] numere={1,2,3,4,5,6,123,4,23,4,5,6,6};
        int medie=0;
        for(int numar : numere){
            medie+=numar;
        }
        medie/=numere.length;
        System.out.println("Media numerelor este: "+medie);
        */
        
        //printPrimes(100); Problema 3;
        //Problema4
        /*
        Car myCar = new Car(60, 20000.0, "Blue");
        double salePrice = myCar.getSalePrice();
        System.out.println("Sale Price: $" + salePrice);
        */
        
	}
}
