
public class Sort {

    public int[] array;
    public int n;
    public int countForMerge;

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

    public int[] byMerge(int[] arr, int m, int n) {
        int middle = (m + n) / 2;

        if (m < n) {
            byMerge(arr, m, middle);
            byMerge(arr, middle + 1, n);
            return merge(arr, m, middle, n);
        }

        else return null;
    }

    public int[] merge(int[] arr, int m, int middle, int n) {
        int[] sortArr = arr;
        countForMerge++;
        int i, j, k;
        i = k = m;
        j = middle + 1;

        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j]) sortArr[k] = arr[i++];
            else sortArr[k] = arr[j++];
            k++;
        }

        if (i > middle)
            for(int t = j; t <= n; t++, k++)
                sortArr[k] = arr[t];
        else
            for(int t = i; t <= middle; t++, k++)
                sortArr[k] = arr[t];

        return sortArr;
    }
}
