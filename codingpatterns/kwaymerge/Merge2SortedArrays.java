package kwaymerge;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */
public class Merge2SortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >= 0 || j >= 0) {
            int first = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int second = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            if (first < second) {
                nums1[index] = nums2[j];
                j--;
            } else {
                nums1[index] = nums1[i];
                i--;
            }
            index--;
        }
    }
}
