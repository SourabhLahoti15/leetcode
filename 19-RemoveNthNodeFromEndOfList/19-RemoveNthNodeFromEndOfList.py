# Last updated: 12/17/2025, 10:54:36 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: Optional[ListNode]
        :type n: int
        :rtype: Optional[ListNode]
        """
        if head == None:
            return head
        if head.next == None:
            head = None
            return head

        p = head
        size = 0
        while p!=None:
            size += 1
            p = p.next
        till = size-n+1
        if till == 1:
            head = head.next
            return head
        p = head
        pidx = 1
        while pidx != till-1:
            p = p.next
            pidx += 1
            
        if p.next != None:
            p.next = p.next.next
        return head


        