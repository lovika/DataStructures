package Arrays;

/**
 * Insertion Sort
 * Test Cases Verified against : https://practice.geeksforgeeks.org/problems/insertion-sort/1
 * Author : Lovika
 */
public class InsertionSort {

    public int[] sortArray(int[] arr) {
        int len = arr.length;
        int[] sortedArr = new int[len];

        System.arraycopy(arr, 0, sortedArr, 0, len);

        for(int i = 1; i < len; i++ ) {
            int val = sortedArr[i];
            for (int j = i-1; j >= 0; j--) {
                if (sortedArr[j] > val) {
                    sortedArr[j+1] = sortedArr[j];
                    sortedArr[j] = val;
                }
            }
        }
        return sortedArr;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 3, 9, 6, 6};

        InsertionSort insertionSort = new InsertionSort();
        int[] sortedArr = insertionSort.sortArray(arr);
        for (int element : sortedArr)
            System.out.println(element);
    }
}