
public class Main {

    public final static int MAX_SIZE = 1_000;
    public static int[] testArray = new int[MAX_SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < MAX_SIZE; ++i) {
            testArray[i] = (int)((Math.random() * 1_000) + 1);
        }

        for (int i = 0; i < MAX_SIZE; ++i) {
            System.out.print(testArray[i] + " ");
        }
    }
}
