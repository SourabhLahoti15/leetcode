// Last updated: 4/4/2026, 1:21:40 PM
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
12    public ListNode oddEvenList(ListNode head) {
13        if (head == null || head.next == null) return head;
14        ListNode odd = head;
15        ListNode evenHead = head.next;
16        ListNode even = head.next;
17        while (even != null && even.next != null) {
18            odd.next = odd.next.next;
19            even.next = even.next.next;
20            odd = odd.next;
21            even = even.next;
22        }
23        odd.next = evenHead;
24        return head;
25    }
26}