// Last updated: 4/15/2026, 9:12:45 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        HashSet<ListNode> set = new HashSet<>();
15        while (headA != null) {
16            set.add(headA);
17            headA = headA.next;
18        }
19        while (headB != null) {
20            if (set.contains(headB)) return headB;
21            headB = headB.next;
22        }
23        return null;
24    }
25}