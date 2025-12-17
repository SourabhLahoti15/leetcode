# Last updated: 12/17/2025, 10:51:55 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def middleNode(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        ll = head
        count = 0
        if head:
            count += 1
            ll = ll.next
        while ll:
            count += 1
            ll = ll.next
        n = (count/2) + 1
        m=1
        ll = head
        while n!=m:
            m+=1
            ll = ll.next
        return ll
        

        