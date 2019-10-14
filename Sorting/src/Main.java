import java.util.Scanner;

public class Main {

    public static int[] result;
    public static long startTime, endTime;
    public final static int MAX_SIZE = 50_000;
    public static int[] testArray = new int[MAX_SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < MAX_SIZE; ++i) {
            testArray[i] = (int)((Math.random() * 50_000) + 1);
        }

        System.out.print("Before sorting \n>> ");
        for (int i = 0; i < MAX_SIZE; ++i) {
            System.out.print(testArray[i] + " ");
        }

        System.out.print("\n\n <Option of sorting> \n1 : Insertion \n2 : Bubble \n3 : Selection " +
                "\n4 : Merge \n5 : Pigeonhole \n6 : Quick (Basic) \n7 : Quick (Random) " +
                "\n8 : Shell \n9 : Radix \n10 : Cocktail \n11 : Pancake \n\ninput : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        Sort sort = new Sort(testArray);
        if (input == 1) {
            startTime = System.nanoTime();
            result = sort.byInsertion(testArray);
            endTime = System.nanoTime();

            printLine(result, endTime - startTime);
        }

        if (input == 2) {
            startTime = System.nanoTime();
            result = sort.byBubble(testArray);
            endTime = System.nanoTime();

            printLine(result, endTime - startTime);
        }

        if (input == 3) {
            startTime = System.nanoTime();
            result = sort.bySelection(testArray);
            endTime = System.nanoTime();

            printLine(result, endTime - startTime);
        }

        if (input == 4) {
            startTime = System.nanoTime();
            sort.byMerge(0, testArray.length - 1);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 5) {
            startTime = System.nanoTime();
            sort.byPigeonhole(testArray.length);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 6) {
            startTime = System.nanoTime();
            sort.byQuick(0, testArray.length - 1);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 7) {
            startTime = System.nanoTime();
            sort.byQuick_random(0, testArray.length - 1);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 8) {
            startTime = System.nanoTime();
            sort.byShell(testArray);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 9) {
            startTime = System.nanoTime();
            sort.byRadix(testArray.length);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }

        if (input == 10) {
            startTime = System.nanoTime();
            result = sort.byCocktail(testArray);
            endTime = System.nanoTime();

            printLine(result, endTime - startTime);
        }

        if (input == 11) {
            startTime = System.nanoTime();
            sort.byPancake(testArray.length - 1);
            endTime = System.nanoTime();

            result = sort.array;
            printLine(result, endTime - startTime);
        }
    }

    public static void printLine(int[] result, long time) {
        System.out.print("After sorting \n>> ");
        for (int i = 0; i < MAX_SIZE; ++i) {
            System.out.print(result[i] + " ");
        }
        System.out.print("\nRUNTIME : " + String.format("%20.12f", time / 1_000_000_000.0) + " sec \n");
    }
}
