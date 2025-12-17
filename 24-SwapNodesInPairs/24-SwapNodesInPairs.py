# Last updated: 12/17/2025, 10:54:34 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if head == None:
            return 
        if head.next == None:
            return head
        p1 = head
        p2 = head.next
        while True:
            p1.val, p2.val = p2.val, p1.val
            if p2.next!=None:
                if p2.next.next!=None:
                    p1 = p2.next
                    p2 = p2.next.next
                else: 
                    break
            else:
                break
        return head
        