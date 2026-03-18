// Last updated: 3/18/2026, 2:55:21 PM
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
11/**
12 * Definition for a binary tree node.
13 * public class TreeNode {
14 *     int val;
15 *     TreeNode left;
16 *     TreeNode right;
17 *     TreeNode() {}
18 *     TreeNode(int val) { this.val = val; }
19 *     TreeNode(int val, TreeNode left, TreeNode right) {
20 *         this.val = val;
21 *         this.left = left;
22 *         this.right = right;
23 *     }
24 * }
25 */
26class Solution {
27    public TreeNode sortedArrayToBST(int[] nums) {
28        int n = nums.length;
29        if (n == 0) return null;
30        int mid = n/2;
31        TreeNode root = new TreeNode(nums[mid]);
32        int[] leftnums = Arrays.copyOfRange(nums, 0, mid);
33        TreeNode left = sortedArrayToBST(leftnums);
34        int[] rightnums = Arrays.copyOfRange(nums, mid+1, n);
35        TreeNode right = sortedArrayToBST(rightnums);
36        root.left = left;
37        root.right = right;
38        return root;
39    }
40    public TreeNode sortedListToBST(ListNode head) {
41        List<Integer> l = new ArrayList<>();
42        ListNode cur = head;
43        while (cur != null) {
44            l.add(cur.val);
45            cur = cur.next;
46        }
47        int n = l.size();
48        int[] arr = new int[n];
49        for (int i=0; i<n; i++) {
50            arr[i] = l.get(i);
51        }
52        return sortedArrayToBST(arr);
53    }
54}