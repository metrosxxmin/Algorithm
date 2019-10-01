import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BigInteger result;
    static long resultForconstant;
    static long startTime, endTime;
    final static int INDEXOFMAX = 70;

    public static void main(String[] argc) {
        System.out.printf("Method \n1 : Recursion \n2 : Dynamic Programming " +
                "\n3 : Space optimize \n4 : Power of Matrix \n5 : Optimaized Power of Matrix " +
                "\n6 : Using formula for Log N \n7 : Using formula for constant\n\ninput : ");
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

        if (input == 2) {
            DynamicProgramming dynamicProgramming = new DynamicProgramming();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = dynamicProgramming.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }

        if (input == 3) {
            SpaceOptimize spaceOptimize = new SpaceOptimize();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = spaceOptimize.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }

        if (input == 4) {
            PowerOfMatrix powerOfMatrix = new PowerOfMatrix();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = powerOfMatrix.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }

        if (input == 5) {
            PowerOfMatrixOptimize powerOfMatrixOptimize = new PowerOfMatrixOptimize();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = powerOfMatrixOptimize.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }

        if (input == 6) {
            FomulaForLogN fomulaForLogN = new FomulaForLogN();
            Arrays.fill(fomulaForLogN.f, BigInteger.ZERO);
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                result = fomulaForLogN.fibonacci(BigInteger.valueOf(i));
                endTime = System.nanoTime();

                printLine(i, result, endTime - startTime);
            }
        }

        if (input == 7) {
            FomulaForConstant fomulaForConstant = new FomulaForConstant();
            for (int i = 0; i <= INDEXOFMAX; ++i) {

                startTime = System.nanoTime();
                resultForconstant = fomulaForConstant.fibonacci(i);
                endTime = System.nanoTime();

                printLine(i, resultForconstant, endTime - startTime);
            }
        }
    }

    // print format
    public static void printLine(int n ,BigInteger bigInteger ,long time) {
        System.out.printf("f<%2d> = %-20d", n, bigInteger);
        System.out.printf(String.format("%20.12f", time / 1_000_000_000.0) + " sec \n");
    }

    // print format for fomulaforconstatnt
    public static void printLine(int n ,long value ,long time) {
        System.out.printf("f<%2d> = %-20d", n,value);
        System.out.printf(String.format("%20.12f", time / 1_000_000_000.0) + " sec \n");
    }
}
