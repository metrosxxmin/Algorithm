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

        System.out.print("\n\n <Option of sorting> \n1 : Insertion \n2 : Bubble\n\ninput : ");
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
    }

    public static void printLine(int[] result, long time) {
        System.out.print("After sorting \n>> ");
        for (int i = 0; i < MAX_SIZE; ++i) {
            System.out.print(result[i] + " ");
        }
        System.out.print("\nRUNTIME : " + String.format("%20.12f", time / 1_000_000_000.0) + " sec \n");
    }
}
