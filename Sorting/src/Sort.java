import java.util.Arrays;
import java.util.Random;

public class Sort {

    public int[] array;
    public int n;

    public Sort(int[] array) {

        this.array = array;
        this.n = array.length;
    }

    // Insertion sort
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

    // Bubble sort
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

    // Selection sort
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

    // Merge sort
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

    // Pigeonhole sort
    public void byPigeonhole(int n) {
        // n is array's length
        int min = array[0];
        int max = min;
        int range, i, j, index;

        for(int a = 0; a < n; ++a) {
            if(array[a] > max) max = array[a];
            if(array[a] < min) min = array[a];
        }

        range = max - min + 1;
        int[] pHole = new int[range];
        Arrays.fill(pHole, 0);

        for(i = 0; i < n; ++i)
            pHole[array[i] - min]++;

        index = 0;
        for(j = 0; j < range; ++j)
            while(pHole[j]-- > 0)
                array[index++] = j + min;

    }

    // Quick sort (divide and conquer)
    public void byQuick(int low, int high) {

        if (low < high) {

            int pi = partition(low, high);
            byQuick(low, pi - 1);
            byQuick(pi + 1, high);
        }
    }

    public int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; ++j)  {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i + 1;

    }

    //Quick sort (random)
    public void byQuick_random(int low, int high) {

        if (low < high) {

            int pi = partition(low, high);
            byQuick_random(low, pi - 1);
            byQuick_random(pi + 1, high);
        }
    }

    public int partition_random(int low, int high) {
        int i = new Random().nextInt(high - low + 1) + low;
        int temp = array[high];
        array[high] =  array[i];
        array[i] = array[temp];

        return partition(low, high);

    }

    // Shell sort
    public int[] byShell(int[] arr) {

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; ++i) {
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    // Radix sort
    public void byRadix(int n) {
        int m = getMax(n);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(n, exp);
    }

    public int getMax(int n) {
        int max = array[0];

        for (int i = 1; i < n; ++i)
            if (array[i] > max)
                max = array[i];

        return max;
    }

    public void countSort(int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; ++i)
            count[ (array[i]/exp)%10 ]++;

        for (i = 1; i < 10; ++i)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            --count[ (array[i]/exp)%10 ];
        }

        for (i = 0; i < n; i++)
            array[i] = output[i];
    }

    // Cocktail sort
    public int[] byCocktail(int[] arr) {
        boolean swapped = true;
        int start = 0, end = arr.length;

        while (swapped == true) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) break;

            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            start++;
        }
        return arr;
    }
}