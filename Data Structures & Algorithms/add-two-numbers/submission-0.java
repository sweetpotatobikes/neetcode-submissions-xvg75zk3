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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int remainder = 0;
        while (l1 != null || l2 != null || remainder != 0) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);

            int sum = l1.val + l2.val + remainder;
            curr.next = new ListNode(sum%10);
            remainder = sum/10; 

            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
