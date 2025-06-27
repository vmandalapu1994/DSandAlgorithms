package binarysearch;

/**
 * @see <a href="https://www.geeksforgeeks.org/problems/find-the-closest-number5513/1">Find the closest number</a>
 */
public class ClosestElement {

    public static int findClosest(int[] arr, int k) {
        if (k < arr[0]) {
            return arr[0];
        }
        if (k > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }
        int s = 0, e = arr.length - 1;
        int m = 0;
        while (s <= e) {
            //Below condition is preferred over m = (s+e)/2 to avoid overflow for large arrays.
            m = s + (e - s) / 2;
            if (arr[m] == k) {
                return arr[m];
            }
            if (arr[m] > k) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        // When loop ends, s>e and both are adjacent.
        // Also, they define a range where K lies so checking s and e would give the solution.
        if (Math.abs(arr[e] - k) < Math.abs(arr[s] - k)) {
            return arr[e];
        } else {
            return arr[s];
        }

    }


}
