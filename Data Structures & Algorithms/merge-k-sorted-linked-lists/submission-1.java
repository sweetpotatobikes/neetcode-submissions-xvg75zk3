/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists) heap.offer(node);

        ListNode dummy = new ListNode(0);
        ListNode iterator = dummy;

        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            iterator.next = curr;

            curr = curr.next;
            iterator = iterator.next;
            if (curr != null) heap.offer(curr);
        }

        return dummy.next;
    }
}
