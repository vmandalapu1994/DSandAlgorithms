package miscellaneous;

/**
 * <a href="https://leetcode.com/problems/sort-colors/description/">Sort Colors</a>
 */
public class SortColors {

    public void sortColors(int[] arr) {
        // Dutch National Flag algorithm :
        // 0 to low-1 -> 0's, low to mid-1 -> 1's, mid to high -> unexplored, high+1 to end -> 2's
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
