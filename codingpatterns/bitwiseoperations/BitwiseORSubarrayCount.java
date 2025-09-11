package bitwiseoperations;

import java.util.stream.IntStream;

/**
 * Give an array of integers, find the count of subarrays whose bitwise OR of elements present in the same subarray.
 * Please optimise for time.
 * <p>
 * For example: [2,4,6,7] ->
 * <p>
 * [2],[4], [6], [7],  [4,6], [4,7], [2,4,6],[4,6,7], [2,4,6,7] have their bitwise OR elements present in the subarray so the count is 9
 */
public class BitwiseORSubarrayCount {

    public Long subArrayCount(int[] arr) {
        Long count = 0L;
        for (int i = 0; i < arr.length; i++) {
            int or = 0;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                or = or | arr[j];
                max = Math.max(max, arr[j]);
                if (or == max) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BitwiseORSubarrayCount bitwiseORSubarrayCount = new BitwiseORSubarrayCount();
        int[] array = IntStream.range(1, 101).toArray();
        Long count = bitwiseORSubarrayCount.subArrayCount(array);
        System.out.println("Sub array count:" + count);
    }
}
