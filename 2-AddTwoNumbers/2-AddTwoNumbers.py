# Last updated: 12/17/2025, 10:54:49 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode()
        l3 = dummy
        carry = 0
        while l1!=None and l2!=None:
            add = l1.val + l2.val + carry
            if add//10:
                carry = add//10
                newNode = ListNode(add%10)
                l3.next = newNode
                l3 = l3.next
            else:
                carry = 0
                newNode = ListNode(add)
                l3.next = newNode
                l3 = l3.next
            l1 = l1.next
            l2 = l2.next
        while l1!=None:
            add = l1.val + carry
            if add//10:
                carry = add//10
                newNode = ListNode(add%10)
                l3.next = newNode
                l3 = l3.next
            else:
                carry = 0
                newNode = ListNode(add)
                l3.next = newNode
                l3 = l3.next
            l1 = l1.next
        while l2!=None:
            add = l2.val + carry
            if add//10:
                carry = add//10
                newNode = ListNode(add%10)
                l3.next = newNode
                l3 = l3.next
            else:
                carry = 0
                newNode = ListNode(add)
                l3.next = newNode
                l3 = l3.next
            l2 = l2.next
        if carry:
            newNode = ListNode(carry)
            l3.next = newNode
        return dummy.next