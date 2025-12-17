# Last updated: 12/17/2025, 10:53:58 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
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
        while p2!=None:
            if p1.val == p2.val:
                p1.next = p2.next
                p2 = p1.next
            else:
                p1 = p1.next
                if p2!=None:
                    p2 = p2.next
        return head
        