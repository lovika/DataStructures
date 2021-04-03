package Arrays;

/**
 * Selection Sort
 * Test Cases Verified against (https://practice.geeksforgeeks.org/problems/selection-sort/1)
 * Author : Lovika Grover
 */
public class SelectionSort {

    public int[] sortArray(int[] arr) {
        int len = arr.length;
        int[] sortedArr = new int[len];
        System.arraycopy(arr, 0, sortedArr, 0, len);
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (sortedArr[j] < sortedArr[min]) {
                    min = j;
                }
            }
            int temp = sortedArr[i];
            sortedArr[i] = sortedArr[min];
            sortedArr[min] = temp;
        }
        return sortedArr;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 3, 9, 6, 6};

        SelectionSort selectionSort = new SelectionSort();
        int[] sortedArr = selectionSort.sortArray(arr);
        for (int element : sortedArr) {
            System.out.println(element);
        }
    }
}
