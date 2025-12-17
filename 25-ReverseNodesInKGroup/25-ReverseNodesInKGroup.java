// Last updated: 12/17/2025, 10:54:29 AM
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
    public ListNode reversell(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            tail.next = head;
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        p1.next = null;
        while (p2 != tail) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p3.next != null) {
                p3 = p3.next;
            }
        }
        p2.next = p1;
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode prevfnode = null;
        for (int i = 0; i < k-1; i++) {
            p = p.next;
        }
        ListNode rnode = p;
        p = head;
        while (p != null) {
            boolean flag = false;
            ListNode localhead = p;
            for (int i = 0; i < k-1; i++) {
                if (p.next == null) {
                    flag = true;
                    break;
                }
                p = p.next;
            }
            if (flag) {
                prevfnode.next = localhead;
                break;
            }
            ListNode temp = null;
            if (p.next != null) {
                temp = p.next;
            }
            ListNode localtail = p;
            ListNode lnode = reversell(localhead, localtail);
            if (prevfnode != null) {
                prevfnode.next = localtail;
            }
            prevfnode = localhead;
            p = temp;
        }
        return rnode;
    }
}