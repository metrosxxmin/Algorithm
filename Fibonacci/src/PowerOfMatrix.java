import java.math.BigInteger;

public class PowerOfMatrix {

    public final static BigInteger zero = BigInteger.ZERO;
    public final static BigInteger one = BigInteger.ONE;

    BigInteger fibonacci(int n) {
        BigInteger F[][] = new BigInteger[][]{{one, one}, {one, zero}};

        if (n == 0)
            return zero;

        power(F, n - 1);

        return F[0][0];
    }

    public void multiply(BigInteger F[][], BigInteger M[][]) {
        BigInteger x = F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
        BigInteger y = F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
        BigInteger z = F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
        BigInteger w = F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    public void power(BigInteger F[][], int n) {
        BigInteger M[][] = new BigInteger[][]{{one, one}, {one,zero}};

        for (int i = 2; i < n + 1; ++i) {
            multiply(F, M);
        }
    }

}