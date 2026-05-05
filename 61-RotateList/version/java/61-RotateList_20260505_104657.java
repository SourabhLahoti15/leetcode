// Last updated: 5/5/2026, 10:46:57 AM
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
12    public ListNode rotateRight(ListNode head, int k) {
13        if (head == null || head.next == null || k == 0) return head;
14        ListNode tail = head;
15        int n = 1;
16        while (tail.next != null) {
17            tail = tail.next;
18            n++;
19        }
20        k = k % n;
21        if (k == 0) return head;
22        tail.next = head;
23        ListNode newTail = head;
24        for (int i = 0; i < n - k - 1; i++) {
25            newTail = newTail.next;
26        }
27        ListNode newHead = newTail.next;
28        newTail.next = null;
29
30        return newHead;
31    }
32}