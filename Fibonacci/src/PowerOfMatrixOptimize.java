import java.math.BigInteger;

public class PowerOfMatrixOptimize {

    public final static BigInteger One = BigInteger.ONE;
    public final static BigInteger Zero = BigInteger.ZERO;

    public BigInteger fibonacci(int n)  {
        BigInteger[][] F = {{One, One}, {One, Zero}};
        if (n == 0) return Zero;

        power(F, n -1);

        return F[0][0];
    }

    public void power(BigInteger F[][], int n) {
        if( n == 0 || n == 1)
            return;
        BigInteger M[][] = {{One, One}, {One, Zero}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    public void multiply(BigInteger F[][], BigInteger M[][]) {
        BigInteger x =  F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
        BigInteger y =  F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
        BigInteger z =  F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
        BigInteger w =  F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
