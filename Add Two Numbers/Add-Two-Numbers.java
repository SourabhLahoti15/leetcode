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
12    public ListNode solve(ListNode l1, ListNode l2, int carry) {
13        if (l1 == null && l2 == null && carry == 0) {
14            return null;
15        }
16        int v1 = (l1 != null) ? l1.val : 0;
17        int v2 = (l2 != null) ? l2.val : 0;
18        int add = v1 + v2 + carry;
19        int ld = add % 10;
20        carry = add / 10;
21        ListNode head = new ListNode(ld);
22        head.next = solve(
23            (l1 != null) ? l1.next : null,
24            (l2 != null) ? l2.next : null,
25            carry);
26        return head;
27    }
28    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
29        // ListNode head = new ListNode(0);
30        // ListNode ln = head;
31        // int carry = 0;
32        // while (l1 != null && l2 != null) {
33        //     int add = l1.val + l2.val + carry;
34        //     carry = add / 10;
35        //     int ld = add % 10;
36        //     ln.next = new ListNode(ld);
37        //     ln = ln.next;
38        //     l1 = l1.next;
39        //     l2 = l2.next;
40        // }
41        // while (l1 != null) {
42        //     int add = l1.val + carry;
43        //     carry = add / 10;
44        //     int ld = add % 10;
45        //     ln.next = new ListNode(ld);
46        //     ln = ln.next;
47        //     l1 = l1.next;
48        // }
49        // while (l2 != null) {
50        //     int add = l2.val + carry;
51        //     carry = add / 10;
52        //     int ld = add % 10;
53        //     ln.next = new ListNode(ld);
54        //     ln = ln.next;
55        //     l2 = l2.next;
56        // }
57        // if (carry != 0)
58        //     ln.next = new ListNode(carry);
59        // return head.next;
60
61        // recursion
62        return solve(l1, l2, 0);
63    }
64}