package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of tasks, where each task is represented as tasks[i] = [start_i, end_i],
 * schedule the tasks on machines with the following criteria:
 * <ul>
 *   <li>Each machine can execute only one task at a time.</li>
 *   <li>A machine can begin a new task immediately after completing the previous one.</li>
 *   <li>An unlimited number of machines are available.</li>
 * </ul>
 * The goal is to find the minimum number of machines required to complete all tasks.
 *
 * <b>Constraints:</b>
 * <ul>
 *   <li>1 &le; tasks.length &le; 10<sup>3</sup></li>
 *   <li>0 &le; tasks[i][0] &lt; tasks[i][1] &le; 10<sup>4</sup></li>
 * </ul>
 */
public class ScheduleTasksOnMinMachines {

    public static int minimumMachines(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> machines = new PriorityQueue<>();

        for (int[] task : tasks) {
            if (!machines.isEmpty() && machines.peek() <= task[0]) {
                machines.poll();
            }
            machines.add(task[1]);
        }

        return machines.size();
    }


}
