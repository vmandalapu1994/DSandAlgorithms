package Heaps;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/maximum-average-pass-ratio/">Maximum Average Pass Ratio</a>
 */

public class MaxAvgPassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Using Max heap to store the gain in pass ratio by adding a new student at each step.
        PriorityQueue<PQEntry> queue = new PriorityQueue<>((a, b) -> Double.compare(b.changePassRatio, a.changePassRatio));
        for (int i = 0; i < classes.length; i++) {
            double currentPassRatio = (double) classes[i][0] / (double) classes[i][1];
            double updatedPassRatio = (double) (classes[i][0] + 1) / (double) (classes[i][1] + 1);
            queue.add(new PQEntry(i, updatedPassRatio - currentPassRatio));
        }

        while (extraStudents > 0) {
            PQEntry entry = queue.poll();
            classes[entry.index][0] += 1;
            classes[entry.index][1] += 1;
            double currentPassRatio = (double) (classes[entry.index][0]) / (double) (classes[entry.index][1]);
            double updatedPassRatio = (double) (classes[entry.index][0] + 1.0) / (double) (classes[entry.index][1] + 1.0);
            queue.add(new PQEntry(entry.index, updatedPassRatio - currentPassRatio));
            extraStudents--;
        }

        double passRationTotal = 0;
        for (int[] c : classes) {
            passRationTotal += (double) c[0] / (double) c[1];
        }
        return passRationTotal / classes.length;
    }

    private class PQEntry {
        int index;
        double changePassRatio;

        PQEntry(int index, double changePassRatio) {
            this.index = index;
            this.changePassRatio = changePassRatio;
        }
    }

}
