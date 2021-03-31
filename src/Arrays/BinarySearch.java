package Arrays;

/*
    Find an item in a sorted list of items
 */
public class BinarySearch {

    public boolean binSearchElement(int arr[], int low, int high, int val) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low)/2;
        if (arr[mid] == val) {
            return true;
        }

        if (arr[mid] > val) {   // value might lie in left part
            return binSearchElement(arr, low, mid-1, val);
        } else {
            return binSearchElement(arr, mid+1, high, val);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 7};
        int len = arr.length;
        int low = 0;
        int high = len - 1;

        BinarySearch bs = new BinarySearch();

        boolean found = bs.binSearchElement(arr, low, high, 6);
        System.out.println(found);
    }
}
