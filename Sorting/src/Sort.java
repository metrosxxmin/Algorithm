import java.util.Arrays;

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

    public void byMerge(int l, int r) {

        if (l < r) {
            int m = (l+r)/2;

            byMerge(l, m);
            byMerge(m+1, r);
            merge(l, m, r);
        }
    }


    public void merge(int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = array[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = array[m + 1+ j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                array[k] = L[i++];
            else
                array[k] = R[j++];
            k++;
        }

        while (i < n1)
            array[k++] = L[i++];
        while (j < n2)
            array[k++] = R[j++];
    }

    // n is array's length
    public void byPigeonhole(int n) {
        int min = array[0];
        int max = min;
        int range, i, j, index;

        for(int a = 0; a < n; a++) {
            if(array[a] > max) max = array[a];
            if(array[a] < min) min = array[a];
        }

        range = max - min + 1;
        int[] pHole = new int[range];
        Arrays.fill(pHole, 0);

        for(i = 0; i < n; i++)
            pHole[array[i] - min]++;

        index = 0;
        for(j = 0; j < range; j++)
            while(pHole[j]-- > 0)
                array[index++] = j + min;

    }
}