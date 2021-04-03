package Arrays;

import java.util.ArrayList;

/**
 * InterviewBit : https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions.
 * You are given a sequence of points and the order in which you need to cover the points.
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 *
 * Author : Lovika Grover
 */
public class MinStepsInInfiniteGrid {

        public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
            int count = 0;

            for(int i = 0; i < A.size() - 1; i++) {
                int diffX = Math.abs(A.get(i) - A.get(i+1));
                int diffY = Math.abs(B.get(i) - B.get(i+1));
                if (diffX == diffY) { // diagonal
                    count += diffX;
                } else {
                    int minDiff = Math.min(diffX, diffY);
                    int maxDiff = Math.max(diffX, diffY);
                    int remaining = maxDiff - minDiff;
                    count += minDiff + remaining;
                }
            }
            return count;
        }
}
