package Arrays;

/**
 * Merge Sort
 * Test Cases verified against https://bit.ly/3fR2XSj
 * Author : Lovika Grover
 */
public class MergeSort {

    public int[] mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return arr;
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high, mid);
        return arr;
    }

    private void merge(int[] arr, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid+1;
        int k = 0;

        while (i < (mid + 1) && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
            k++;
        }

        if (i < (mid+1)) {
            while (i < (mid+1)) {
                temp[k] = arr[i++];
                k++;
            }
        }

        if (j <= high) {
            while (j <= high) {
                temp[k] = arr[j++];
                k++;
            }
        }
        for (int ptr = 0; ptr < (high-low+1); ptr++) {
            arr[ptr+low] = temp[ptr];
        }
    }

    public static void main (String[] args) {
        int[] arr = {4, 5, 1, 8, 3, 9, 6, 6};

        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int element : sortedArray) {
            System.out.println(element);
        }
    }
}
