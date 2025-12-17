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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode head = new ListNode(0);
14        ListNode ln = head;
15        int carry = 0;
16        while (l1 != null && l2 != null) {
17            int add = l1.val + l2.val + carry;
18            carry = add / 10;
19            int ld = add % 10;
20            ln.next = new ListNode(ld);
21            ln = ln.next;
22            l1 = l1.next;
23            l2 = l2.next;
24        }
25        while (l1 != null) {
26            int add = l1.val + carry;
27            carry = add / 10;
28            int ld = add % 10;
29            ln.next = new ListNode(ld);
30            ln = ln.next;
31            l1 = l1.next;
32        }
33        while (l2 != null) {
34            int add = l2.val + carry;
35            carry = add / 10;
36            int ld = add % 10;
37            ln.next = new ListNode(ld);
38            ln = ln.next;
39            l2 = l2.next;
40        }
41        if (carry != 0)
42            ln.next = new ListNode(carry);
43        return head.next;
44    }
45}