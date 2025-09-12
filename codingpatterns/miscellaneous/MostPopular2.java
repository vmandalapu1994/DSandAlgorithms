package miscellaneous;

import java.util.*;

/**
 * Given a stream of contentIds with increase/decrease of popularity, find the most popular content Id.
 */
class MostPopular2 {

    Map<Integer, Integer> contentMap;

    PriorityQueue<int[]> popularityMap;

    public MostPopular2() {
        this.contentMap = new HashMap<>();
        this.popularityMap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    }

    // Time complexity: O(logn)
    void increasePopularity(Integer contentId) {
        Integer prevCount = contentMap.getOrDefault(contentId, 0);
        int newCount = prevCount + 1;
        contentMap.put(contentId, newCount);
        this.popularityMap.add(new int[]{contentId, newCount});
    }

    //Time complexity: avg O(1) but can go up to O(K) where K is number of updates from the last mostPopular() call.
    Integer mostPopular() {
        if (this.popularityMap.isEmpty()) {
            return -1;
        }
        while (true) {
            int[] element = this.popularityMap.peek();
            int contentId = element[0];
            int popularity = element[1];
            if (this.contentMap.get(contentId) == popularity) {
                return popularity;
            }
            this.popularityMap.poll();
        }
    }

    // Time complexity: O(logn)
    void decreasePopularity(Integer contentId) {
        if (!contentMap.containsKey(contentId)) {
            return;
        }
        Integer prevCount = contentMap.get(contentId);
        int newCount = prevCount - 1;
        contentMap.put(contentId, newCount);
        if (newCount != 0) {
            this.popularityMap.add(new int[]{contentId, newCount});
        }
    }

    public static void main(String[] args) {
        MostPopular2 popularityTracker = new MostPopular2();

        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns -1
    }

}

