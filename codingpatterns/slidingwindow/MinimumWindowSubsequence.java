package slidingwindow;

/**
 * @see <a href="https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1"></a>
 */

/**
 * 1) Scan through the first string to find a segment containing all the characters of the second string in order.
 * 2) Once a complete segment is found, backtrack from the end to the start, adjusting the segment to be as small as possible while including all characters of the second string.
 * 3) If the current segment is smaller than the previously found smallest segment, update it to the new smaller segment.
 * 4) Continue searching for the next valid segment and repeat the shrinking process.
 * 5) After processing the entire first string, find all possible valid segments and return the smallest one containing all characters of the second string.
 */
public class MinimumWindowSubsequence {


    static String minWindow(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int start1 = 0;
        int length = Integer.MAX_VALUE;
        String str = null;
        for (int start2 = 0; start1 < s1.length(); ) {
            if (ch1[start1] == ch2[start2]) {
                start2++;
            }
            //Found substring
            if (start2 == ch2.length) {
                start2--;
                int start = start1;
                int end = start1;
                //Back track to find the min length substring having s2 as a subsequence.
                while (start2 >= 0) {
                    if (ch1[start] == ch2[start2]) {
                        start2--;
                    }
                    start--;
                }
                start++;
                if (length > (end - start + 1)) {
                    length = end - start + 1;
                    str = s1.substring(start, end + 1);
                }
                start2 = 0;
                start1 = start;
            }
            start1++;
        }
        return str == null ? "" : str;
    }

    public static void main(String[] args) {

        System.out.println(minWindow("geeksforgeeks", "eksrg"));

    }


}
