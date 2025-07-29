package Heaps;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 */
public class MedianOfDataStream {

    PriorityQueue<Integer> minHeap;

    PriorityQueue<Integer> maxHeap;

    public MedianOfDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
            // Balance the heap sizes
            if (maxHeap.size() > 1 + minHeap.size()) {
                int val = maxHeap.poll();
                minHeap.add(val);
            }
        } else {
            minHeap.add(num);
            // Balance the heap sizes
            if (minHeap.size() > 1 + maxHeap.size()) {
                int val = minHeap.poll();
                maxHeap.add(val);
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        }
    }

}
