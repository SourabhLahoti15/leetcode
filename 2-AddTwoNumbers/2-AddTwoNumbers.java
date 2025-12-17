// Last updated: 12/17/2025, 10:54:47 AM
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
    public ListNode solve(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int v1 = (l1 != null) ? l1.val : 0;
        int v2 = (l2 != null) ? l2.val : 0;
        int add = v1 + v2 + carry;
        int ld = add % 10;
        carry = add / 10;
        ListNode head = new ListNode(ld);
        head.next = solve(
            (l1 != null) ? l1.next : null,
            (l2 != null) ? l2.next : null,
            carry);
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode head = new ListNode(0);
        // ListNode ln = head;
        // int carry = 0;
        // while (l1 != null && l2 != null) {
        //     int add = l1.val + l2.val + carry;
        //     carry = add / 10;
        //     int ld = add % 10;
        //     ln.next = new ListNode(ld);
        //     ln = ln.next;
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }
        // while (l1 != null) {
        //     int add = l1.val + carry;
        //     carry = add / 10;
        //     int ld = add % 10;
        //     ln.next = new ListNode(ld);
        //     ln = ln.next;
        //     l1 = l1.next;
        // }
        // while (l2 != null) {
        //     int add = l2.val + carry;
        //     carry = add / 10;
        //     int ld = add % 10;
        //     ln.next = new ListNode(ld);
        //     ln = ln.next;
        //     l2 = l2.next;
        // }
        // if (carry != 0)
        //     ln.next = new ListNode(carry);
        // return head.next;

        // recursion
        return solve(l1, l2, 0);
    }
}