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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode tail1 = head; // tail of first list
        ListNode head2 = head; // head of second list - SLOW
        ListNode tail2 = head; // tail of second list - FAST

        while (tail2 != null && tail2.next != null) {
            tail1 = head2;
            tail2 = tail2.next.next;
            head2 = head2.next;
        }

        tail1.next = null;

        ListNode l2 = this.reverse(head2);
        this.merge2Lists(head, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void merge2Lists(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;
            if (l1_next == null) return;
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
