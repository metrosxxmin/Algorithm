import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger result;
    static long startTime, endTime;
    final static int INDEXOFMAX = 90;

    public static void main(String[] argc) {
        System.out.printf("Method \n1 : Recursion \n\ninput : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == 1) {
            Recursion recursion = new Recursion();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = recursion.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }


    }

    // print format
    public static void printLine(int n ,BigInteger bigInteger ,long time) {
        System.out.printf("f<%2d> = %-20d", n, bigInteger);
        System.out.printf(String.format("%20.12f", time / 1_000_000_000.0) + " sec \n");
    }
}
