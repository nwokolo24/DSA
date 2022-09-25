package numbers;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 8;
        System.out.println(isPrime(num));
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
