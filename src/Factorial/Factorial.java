import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorialVal = BigInteger.ONE;
    public static BigInteger factorialOfNumber(int n) {
        if (n < 1) {
            return BigInteger.ONE;
        }
        factorialVal = factorialVal.multiply(BigInteger.valueOf(n).multiply(factorialOfNumber(n-1)));

        return factorialVal;
    }

    public static void main(String[] args) {
        System.out.println(factorialOfNumber(3));
    }
}
