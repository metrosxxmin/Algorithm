import java.math.BigInteger;

public class DynamicProgramming {
    public final static int MAXSIZE = 100_000;
    public BigInteger[] array = new BigInteger[MAXSIZE];

    public DynamicProgramming() {
        this.array[0] = BigInteger.ZERO;
        this.array[1] = BigInteger.ONE;
    }

    public BigInteger fibonacci(int n) {

        if (n == 0) return array[0];
        if (n == 1) return array[1];

        for (int i = 2; i <= n; ++i) {
            array[i] = array[i - 1].add(array[i - 2]);
        }
        return array[n];
    }
}
