import java.math.BigInteger;

public class SpaceOptimize {

    public final static BigInteger zero = BigInteger.ZERO;
    public final static BigInteger one = BigInteger.ONE;

    public BigInteger fibonacci(int n) {
        BigInteger a = zero;
        BigInteger b = one;
        BigInteger c = zero;

        if (n == 0)
            return a;

        for (int i = 2; i <= n; ++i) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }
}