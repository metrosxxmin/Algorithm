import java.math.BigInteger;

//    If n is even then k = n/2:
//    F(n) = [2*F(k-1) + F(k)]*F(k)

//    If n is odd then k = (n + 1)/2
//    F(n) = F(k)*F(k) + F(k-1)*F(k-1)

public class FomulaForLogN {

    public final static BigInteger zero = BigInteger.ZERO;
    public final static BigInteger one = BigInteger.ONE;
    public final static BigInteger two = one.add(one);
    public BigInteger f[];

    public BigInteger fibonacci(BigInteger n) {

        if (n.equals(zero)) return zero;
        if (n.equals(one) || n.equals(two)) return (f[n.intValue()] = one);
        if (!f[n.intValue()].equals(zero))
            return f[n.intValue()];

        BigInteger k;
        if (n.mod(two) == zero) {
            k = n.divide(two);
            f[n.intValue()] = (two.multiply(fibonacci(k.subtract(one)))
                    .add(fibonacci(k))).multiply(fibonacci(k));
        }
        else {
            k = n.add(one).divide(two);
            f[n.intValue()] = (fibonacci(k).multiply(fibonacci(k))
                    .add(fibonacci(k.subtract(one)))).multiply(fibonacci(k).subtract(one));
        }

        return f[n.intValue()];
    }
}
