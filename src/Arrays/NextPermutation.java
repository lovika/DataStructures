package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order
 *
 * https://www.interviewbit.com/problems/next-permutation/
 *
 * Approach :
 * 1. Traverse from right till the next element(E) is less then current
 * 2. Sort the right part of array and find the next greater element to E and swap it with E.
 * Comlexity : n^2 in worst case (can be done in nlogn with better sorting algorithm -> Collections.sort(a.subList(index+1, n));)
 *
 */
public class NextPermutation {

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        boolean swap = false;
        int len = A.size();
        for (int i = len - 1; i > 0 ; i--) {
            if (A.get(i).compareTo(A.get(i-1)) > 0) {
                for (int k = i; k < len; k++) {
                    for (int j = k+1; j < len; j++) {
                        if (A.get(j) < A.get(k)) {
                            int tmp = A.get(k);
                            A.set(k, A.get(j));
                            A.set(j, tmp);
                        }
                    }
                    if ((A.get(i-1) < A.get(k)) && !swap) {
                        int temp = A.get(i-1);
                        A.set(i-1, A.get(k));
                        A.set(k, temp);
                        swap = true;
                    }
                }
                break;
            }
        }
        if (!swap) {
            A.sort(Comparator.naturalOrder());
        }
        return A;
    }
//A : [ 701, 319, 695, 52 ]
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(701);
        A.add(319);
        A.add(695);
        A.add(52);
        NextPermutation next = new NextPermutation();
        ArrayList<Integer> arr = next.nextPermutation(A);
        System.out.println(arr);
    }
}
