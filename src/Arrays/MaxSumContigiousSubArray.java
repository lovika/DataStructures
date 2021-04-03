package Arrays;

import java.util.List;

/**
 * InterviewBit : https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 *
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * Author : Lovika Grover
 */
public class MaxSumContigiousSubArray {

    public int maxSubArray(final List<Integer> A) {
        int maxSum = 0;
        int maxValue = A.get(0);
        int sum = 0;
        int len = A.size();
        int i = 0;
        while (i < len) {
            sum += A.get(i);
            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum <= 0) {
                sum = 0;
            }

            if (maxValue < A.get(i)) {
                maxValue = A.get(i);
            }
            i++;
        }

        if (maxSum == 0) {
            return maxValue;
        }
        return maxSum;
    }
}
