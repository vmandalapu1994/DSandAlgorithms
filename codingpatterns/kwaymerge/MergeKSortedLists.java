package kwaymerge;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode root = null, curr = null;
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            ListNode ln = new ListNode(n.val);
            if (curr == null) {
                curr = ln;
                root = ln;
            } else {
                curr.next = ln;
                curr = ln;
            }
            if (n.next != null) {
                queue.add(n.next);
            }
        }
        return root;
    }
}
