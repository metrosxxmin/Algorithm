
public class Sort {

    public int[] array;
    public int n;

    public Sort(int[] array) {

        this.array = array;
        this.n = array.length;
    }

    public int[] byInsertion(int[] arr) {

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public int[] byBubble(int[] arr) {

        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public int[] bySelection(int[] arr) {

        for (int i = 0; i < n - 1; ++i) {
            int minOfidx = i;

            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[minOfidx]) {
                    minOfidx = j;
                }
            }
            int tmp = arr[minOfidx];
            arr[minOfidx] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
}
