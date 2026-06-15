// Last updated: 6/15/2026, 10:09:12 PM
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
12    public int len(ListNode head) {
13        int len = 0;
14        ListNode p = head;
15        while (p != null) {
16            len++;
17            p = p.next;
18        }
19        return len;
20    }
21    public ListNode deleteMiddle(ListNode head) {
22        int n = len(head);
23        if (n == 1) {
24            head = null;
25            return head;
26        }
27        ListNode p = head;
28        for (int i=0; i<n/2 - 1; i++) {
29            p = p.next;
30        }
31        p.next = p.next.next;
32        return head;
33    }
34}