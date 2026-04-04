// Last updated: 4/4/2026, 1:33:40 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseList(ListNode head) {
13        if (head == null || head.next == null) return head;
14        ListNode p1 = head;
15        ListNode p2 = head.next;
16        ListNode p3 = head.next.next;
17        head.next = null;
18        while (p2 != null) {
19            p2.next = p1;
20            p1 = p2;
21            p2 = p3;
22            if (p3 != null) p3 = p3.next;
23        }
24        return p1;
25    }
26}