1# Definition for singly-linked list.
2# class ListNode(object):
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution(object):
7    def addTwoNumbers(self, l1, l2):
8        """
9        :type l1: Optional[ListNode]
10        :type l2: Optional[ListNode]
11        :rtype: Optional[ListNode]
12        """
13        dummy = ListNode()
14        l3 = dummy
15        carry = 0
16        while l1!=None and l2!=None:
17            add = l1.val + l2.val + carry
18            if add//10:
19                carry = add//10
20                newNode = ListNode(add%10)
21                l3.next = newNode
22                l3 = l3.next
23            else:
24                carry = 0
25                newNode = ListNode(add)
26                l3.next = newNode
27                l3 = l3.next
28            l1 = l1.next
29            l2 = l2.next
30        while l1!=None:
31            add = l1.val + carry
32            if add//10:
33                carry = add//10
34                newNode = ListNode(add%10)
35                l3.next = newNode
36                l3 = l3.next
37            else:
38                carry = 0
39                newNode = ListNode(add)
40                l3.next = newNode
41                l3 = l3.next
42            l1 = l1.next
43        while l2!=None:
44            add = l2.val + carry
45            if add//10:
46                carry = add//10
47                newNode = ListNode(add%10)
48                l3.next = newNode
49                l3 = l3.next
50            else:
51                carry = 0
52                newNode = ListNode(add)
53                l3.next = newNode
54                l3 = l3.next
55            l2 = l2.next
56        if carry:
57            newNode = ListNode(carry)
58            l3.next = newNode
59        return dummy.next