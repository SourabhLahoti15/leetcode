# Last updated: 12/17/2025, 10:53:10 AM
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
        s = ""
        p = head
        while p != None:
            s += str(p.val)
            p = p.next
        if s == s[::-1]:
            return True
        else: 
            return False

        