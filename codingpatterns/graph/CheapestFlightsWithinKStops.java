package graph;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">Cheapest Flights Within K Stops</a>
 * <p>
 * Needs revision.
 */

public class CheapestFlightsWithinKStops {

    public int findCheapestPriceUsingDijkstra(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> list = new HashMap<>();
        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int price = flight[2];
            list.putIfAbsent(source, new ArrayList<>());
            list.get(source).add(new int[]{dest, price});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{src, 0, 0});
        int[] dist = new int[n];
        int[] stops = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int station = entry[0];
            int stopCount = entry[1];
            int price = entry[2];
            if (station == dst) {
                return price;
            }
            if (dist[station] < price && stops[station] < stopCount) {
                continue;
            }
            dist[station] = price;
            stops[station] = stopCount;
            if (list.get(station) == null) {
                continue;
            }
            for (int[] neighbour : list.get(station)) {
                if (stopCount <= k) {
                    queue.offer(new int[]{neighbour[0], stopCount + 1, price + neighbour[1]});
                }
            }
        }
        return -1;
    }


    public int findCheapestPriceUsingBFS(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> list = new HashMap<>();
        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int price = flight[2];
            list.putIfAbsent(source, new ArrayList<>());
            list.get(source).add(new int[]{dest, price});
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{src, 0, 0});
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Integer finalPrice = Integer.MAX_VALUE;
        prices[src] = 0;
        while (!queue.isEmpty()) {
            int[] entry = queue.removeFirst();
            int station = entry[0];
            int stops = entry[1];
            int price = entry[2];
            if (station == dst) {
                if (finalPrice > price) {
                    finalPrice = price;
                }
                continue;
            }
            if (list.get(station) == null) {
                continue;
            }
            for (int[] neighbour : list.get(station)) {
                if (stops <= k) {
                    // Push to the Queue only when the new price is smaller than the existing one.
                    int newPrice = price + neighbour[1];
                    if (newPrice < prices[neighbour[0]]) {
                        prices[neighbour[0]] = newPrice;
                        queue.addLast(new int[]{neighbour[0], stops + 1, price + neighbour[1]});
                    }
                }
            }
        }
        return finalPrice == Integer.MAX_VALUE ? -1 : finalPrice;
    }

}
