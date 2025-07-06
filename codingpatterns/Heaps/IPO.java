package Heaps;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/ipo/">IPO</a>
 */

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Min heap to store all projects based on capital
        PriorityQueue<PQEntry> capitalHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.capital, b.capital));

        for (int i = 0; i < capital.length; i++) {
            capitalHeap.add(new PQEntry(capital[i], profits[i]));
        }

        // Max heap to store all projects based on profit
        PriorityQueue<PQEntry> profitsHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.profit, a.profit));


        for (int i = 0; i < k; i++) {
            // Fetch all affordable projects and add to profits max heap
            while (!capitalHeap.isEmpty() && capitalHeap.peek().capital <= w) {
                PQEntry entry = capitalHeap.poll();
                profitsHeap.add(entry);
            }
            // If there is any affordable project, add its profit otherwise 0;
            w += !profitsHeap.isEmpty() ? profitsHeap.poll().profit : 0;
        }

        return w;
    }

    private static class PQEntry {
        int capital;

        int profit;

        PQEntry(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

}
