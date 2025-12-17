// Last updated: 12/17/2025, 10:51:10 AM
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
    public int len(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
    public ListNode deleteMiddle(ListNode head) {
        int n = len(head);
        if (n == 1) {
            head = null;
            return head;
        }
        ListNode p = head;
        for (int i=0; i<n/2 - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}