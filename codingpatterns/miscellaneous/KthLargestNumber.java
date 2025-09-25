package miscellaneous;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">Kth Largest Element in an Array</a>
 */
public class KthLargestNumber {

    private Random random = new Random();

    // Using Heap
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    // Using 3way partitioning quick selection
    public int findKthLargest3WayQuickSelect(int[] nums, int k) {
        return quickSelect3WayPartition(nums, 0, nums.length - 1, nums.length - k);
    }

    // Using Quick select
    public int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int pos) {
        if (start == end) {
            return nums[start];
        }
        int pivotIndex = start + random.nextInt(end - start + 1);
        swap(nums, pivotIndex, end);
        int pivot = nums[end];
        int p = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums, p, end);
        if (p < pos) {
            return quickSelect(nums, p + 1, end, pos);
        } else if (p > pos) {
            return quickSelect(nums, start, p - 1, pos);
        }
        return nums[p];
    }

    private int quickSelect3WayPartition(int[] nums, int start, int end, int pos) {
        // 3-way partitioning (<lt smaller elements, >gt larger elements, lt to gt inclusive equal elements)
        while (start <= end) {
            int pivotIndex = start + random.nextInt(end - start + 1);
            int pivot = nums[pivotIndex];
            int lt = start, gt = end, index = start;
            while (index <= gt) {
                if (nums[index] > pivot) {
                    swap(nums, index, gt--);
                } else if (nums[index] < pivot) {
                    swap(nums, index++, lt++);
                } else {
                    index++;
                }
            }
            if (pos < lt) {
                end = lt - 1;
            } else if (pos > gt) {
                start = gt + 1;
            } else {
                return nums[pos];
            }
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
