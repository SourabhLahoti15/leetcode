# Last updated: 12/17/2025, 10:52:39 AM
class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        slist = list(s)
        for c in t:
            if c not in slist:
                return c
            else:
                slist.remove(c)
        
        