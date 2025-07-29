package Heaps;

import java.util.*;


/**
 * @see <a href="https://leetcode.com/problems/sliding-window-median/">Sliding Window Median</a>
 */
public class SlidingWindowMedian {

    // Logical counters tracking the number of elements present in the heap corresponding to the current window
    int maxHeapSize = 0, minHeapSize = 0;

    // Map for lazy removal of elements
    Map<Integer, Integer> toRemove = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        List<Double> medians = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            addEle(maxHeap, minHeap, nums[i]);
            balance(maxHeap, minHeap);
        }

        medians.add(median(maxHeap, minHeap, k));

        for (int i = k; i < nums.length; i++) {
            int removed = nums[i - k];
            toRemove.putIfAbsent(removed, 0);
            toRemove.put(removed, toRemove.get(removed) + 1);
            int add = nums[i];
            // Decrese the counters to keep the count of the valid elements for the current window
            if (maxHeap.peek() >= removed) {
                maxHeapSize--;
            } else {
                minHeapSize--;
            }

            addEle(maxHeap, minHeap, add);
            // During balance, no stale top would be moved to the other heap
            balance(maxHeap, minHeap);

            // Remove stale top elements so that we use valid elements for median calculation.
            prune(maxHeap);
            prune(minHeap);

            medians.add(median(maxHeap, minHeap, k));
        }

        return medians.stream().mapToDouble(ele -> ele).toArray();


    }

    private double median(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        if (k % 2 == 1) {
            return maxHeap.peek();
        }
        return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
    }

    private void addEle(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int add) {
        if (maxHeap.isEmpty() || maxHeap.peek() > add) {
            maxHeap.add(add);
            maxHeapSize++;
        } else {
            minHeap.add(add);
            minHeapSize++;
        }
    }

    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeapSize > 1 + minHeapSize) {
            minHeap.add(maxHeap.poll());
            minHeapSize++;
            maxHeapSize--;
        }

        if (maxHeapSize < minHeapSize) {
            maxHeap.add(minHeap.poll());
            maxHeapSize++;
            minHeapSize--;
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && toRemove.containsKey(heap.peek())) {
            toRemove.put(heap.peek(), toRemove.get(heap.peek()) - 1);
            if (toRemove.get(heap.peek()) == 0) {
                toRemove.remove(heap.peek());
            }
            heap.poll();
        }
    }
}
