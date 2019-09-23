import java.math.BigInteger;

public class Recursion {

    public BigInteger fibonacci(int n) {
        if (n < 2) return BigInteger.valueOf(n);

        return fibonacci(n - 1).add(fibonacci(n - 2));
    }
}