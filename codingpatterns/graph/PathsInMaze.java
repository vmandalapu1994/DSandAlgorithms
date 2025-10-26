package graph;

import java.util.*;

/**
 * Problem: Confusion Score in a Maze
 * <p>
 * A maze consists of n rooms numbered from 1 to n, and some rooms are connected by corridors.
 * You are given a 2D integer array `corridors`, where corridors[i] = [room1, room2] indicates
 * that there is a corridor connecting room1 and room2, allowing movement in both directions.
 * <p>
 * The designer of the maze wants to know how confusing the maze is. The confusion score of
 * the maze is defined as the number of different cycles of length 3.
 * <p>
 * Example:
 * 1 -> 2 -> 3 -> 1  is a cycle of length 3
 * 1 -> 2 -> 3 -> 4  is NOT a cycle of length 3
 * 1 -> 2 -> 3 -> 2 -> 1 is NOT a cycle of length 3
 * <p>
 * Two cycles are considered different if one or more of the rooms in the first cycle are not
 * in the second cycle.
 * <p>
 * Return the confusion score of the maze.
 * <p>
 * Constraints:
 * 2 <= n <= 100
 * 1 <= corridors.length <= 5 * 10^2
 * corridors[i].length = 2
 * 1 <= room1_i, room2_i <= n
 * room1_i != room2_i
 * There are no duplicate corridors.
 */
public class PathsInMaze {

    public static int numberOfPaths(int n, int[][] corridors) {
        List<Set<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
        }

        for (int[] corridor : corridors) {
            adjacencyList.get(corridor[0] - 1).add(corridor[1] - 1);
            adjacencyList.get(corridor[1] - 1).add(corridor[0] - 1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int neighbour1 : adjacencyList.get(i)) {
                if (neighbour1 < i) {
                    continue;
                }
                for (int neighbour2 : adjacencyList.get(neighbour1)) {
                    if (neighbour2 < neighbour1) {
                        continue;
                    }
                    if (adjacencyList.get(neighbour2).contains(i)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 1.	Create an adjacency matrix to store the rooms as keys and its neighbor rooms as the corresponding values.
     * Create a counter to store the number of cycles.
     * 2.	Start iterating over corridors, and store the neighbors of room1 and room2 in the matrix.
     * 3.	Take the intersection of the neighbors of room1 and room2 and add the length of the result to the counter.
     * 4.	Repeat this process until we have iterated over all corridors.
     */

    public static int numberOfPathsOptimised(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        int count = 0;

        for (int[] corridor : corridors) {
            adjacencyList.putIfAbsent(corridor[0], new HashSet<>());
            adjacencyList.putIfAbsent(corridor[1], new HashSet<>());
            adjacencyList.get(corridor[0]).add(corridor[1]);
            adjacencyList.get(corridor[1]).add(corridor[0]);
            count += intersectionCount(adjacencyList.get(corridor[0]), adjacencyList.get(corridor[1]));
        }
        return count;
    }

    private static int intersectionCount(Set<Integer> neighbours1, Set<Integer> neighbours2) {
        int count = 0;
        for (Integer n1 : neighbours1) {
            if (neighbours2.contains(n1)) {
                count++;
            }
        }
        return count;
    }

}

