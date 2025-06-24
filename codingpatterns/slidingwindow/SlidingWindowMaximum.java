package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 */

/*
 * 1) Initialize an empty deque data structure.
 * 2) Iterate through the first w elements in the input array, performing cleanup operations on the deque to maintain a decreasing order of values.
 * 3) Store the maximum value of the initial window.
 * 4) Slide the window through the array, updating the deque and storing maximum values for each window.
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            cleanup(dequeue, i, nums);
            dequeue.add(i);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[dequeue.getFirst()];
        for (int i = k; i < nums.length; i++) {
            cleanup(dequeue, i, nums);
            if (!dequeue.isEmpty() && i - k == dequeue.getFirst()) {
                dequeue.removeFirst();
            }
            dequeue.add(i);
            result[i - k + 1] = nums[dequeue.getFirst()];
        }
        return result;
    }

    private void cleanup(Deque<Integer> dequeue, int i, int[] nums) {
        while (!dequeue.isEmpty() && nums[dequeue.getLast()] <= nums[i]) {
            dequeue.removeLast();
        }
    }

}
