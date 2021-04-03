package Arrays;

/**
 * Bubble Sort
 * Test Cases Verified on gfg (https://bit.ly/3wrdHN4)
 * Author : Lovika Grover
 */
public class BubbleSort {

    public int[] sortArray(int arr[]) {
        int len = arr.length;
        int[] sortedArr = new int[len];

        System.arraycopy(arr, 0, sortedArr, 0, len);

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j+1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j+1];
                    sortedArr[j+1] = temp;
                }
            }
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 3, 9, 6, 6};

        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedArr = bubbleSort.sortArray(arr);
        for (int j : sortedArr)
            System.out.println(j);

    }
}
