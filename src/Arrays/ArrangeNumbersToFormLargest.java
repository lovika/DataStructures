package Arrays;

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example:
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * https://www.interviewbit.com/problems/largest-number/
 * (Solution same as Interview Bit provided)
 *
 * https://www.edureka.co/blog/string-vs-stringbuffer-vs-stringbuilder/
 *
 */




public class ArrangeNumbersToFormLargest {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        String[] str = new String[A.size()];
        for (int i = 0; i < A.size(); i++) {
            str[i] = String.valueOf(A.get(i));
        }

        Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));


        StringBuilder op = new StringBuilder();
        for (String a : str) {
            op.append(a);
        }

        if (op.charAt(0) == '0') {
            return "0";
        }
        return op.toString();
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(0, 0);
        ArrangeNumbersToFormLargest arrange = new ArrangeNumbersToFormLargest();
        String op = arrange.largestNumber(A);
        System.out.println(op);
    }
}
