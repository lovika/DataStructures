package Arrays;

/**
 * Bubble Sort
 * Author : Lovika Grover
 */
public class BubbleSort {

    public int[] sortArray(int arr[]) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 1, 8, 3, 9, 6, 6};

        BubbleSort bubbleSort = new BubbleSort();
        int sortedArr[] = bubbleSort.sortArray(arr);
        for (int i = 0 ; i < sortedArr.length; i++)
            System.out.println(sortedArr[i]);

    }
}
