import java.util.Random;

public class Sorting {
    private long comparisons;
    private final Random random = new Random();

    public long selectionSort(int[] a) {
        comparisons = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (a[j] < a[min_idx])
                    min_idx = j;
            }
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
        return comparisons;
    }

    public long mergeSort(int[] a) {
        comparisons = 0;
        sort(a, 0, a.length - 1);
        return comparisons;
    }

    private void merge(int a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    private void sort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public long heapSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

        return comparisons;
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n) {
            comparisons++;
            if (arr[l] > arr[largest])
                largest = l;
        }

        if (r < n) {
            comparisons++;
            if (arr[r] > arr[largest])
                largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public long quickSortFirstPivot(int[] a) {
        comparisons = 0;
        quickSortFP(a, 0, a.length - 1);
        return comparisons;
    }

    private int partitionFirstPivot(int a[], int low, int high) {
        int pivot = a[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            comparisons++;
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i];
        a[i] = a[low];
        a[low] = temp;
        return i;
    }

    private void quickSortFP(int a[], int l, int h) {
        if (l < h) {
            int pi = partitionFirstPivot(a, l, h);
            quickSortFP(a, l, pi - 1);
            quickSortFP(a, pi + 1, h);
        }
    }

    public long quickSortRandomPivot(int[] a) {
        comparisons = 0;
        quickSortRP(a, 0, a.length - 1);
        return comparisons;
    }

    private void quickSortRP(int a[], int l, int h) {
        if (l < h) {
            int randIdx = l + random.nextInt(h - l + 1);
            int temp = a[l];
            a[l] = a[randIdx];
            a[randIdx] = temp;

            int pi = partitionFirstPivot(a, l, h);
            quickSortRP(a, l, pi - 1);
            quickSortRP(a, pi + 1, h);
        }
    }

}