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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevTail = dummy;

        while (prevTail.next != null) {
            ListNode groupHead = prevTail.next;
            ListNode groupTail = this.getKth(prevTail, k);

            if (groupTail == null) break; // leave as is

            ListNode nextHead = groupTail.next; // remember next group head
            groupTail.next = null; // isolate current group

            ListNode reversedGroupHead = reverse(groupHead);

            // reconnect
            prevTail.next = reversedGroupHead;
            groupHead.next = nextHead;

            // groupHead got reversed so now its the tail
            prevTail = groupHead;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
