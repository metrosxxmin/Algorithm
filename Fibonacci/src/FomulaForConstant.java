
// Fn = {[(√5 + 1)/2] ^ n} / √5

public class FomulaForConstant {

    public final static double phi = (1 + Math.sqrt(5)) / 2;

    public long fibonacci(int n) {
        return (long)(Math.round(Math.pow(phi, n)) / Math.sqrt(5));
    }

}


