// Last updated: 12/17/2025, 10:51:02 AM
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> l = new HashSet<>();
        for (int num : nums) {
            l.add(num);
        }
        while (l.contains(head.val) && head.next != null) {
            head = head.next;
        }
        if (head.next == null && l.contains(head.val)) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            while (l.contains(p.next.val)) {
                p.next = p.next.next;
                if (p.next == null) {
                    break;
                } 
            }
            if (p.next == null) {
                break;
            }
            p = p.next;
        }
        return head;
    }
}