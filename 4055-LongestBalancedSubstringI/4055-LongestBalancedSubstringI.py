# Last updated: 12/17/2025, 10:50:51 AM
class Solution(object):
    def longestBalanced(self, s):
        """
        :type s: str
        :rtype: int
        """
        def isSame(arr):
            d = {}
            for i in arr:
                d[i] = d.get(i, 0) + 1
            if len(d.values()) == 1:
                return True
            else:
                return False
        d = {}
        ml = 0
        p = 0
        while p<len(s):
            for i in range(p, len(s)):
                d[s[i]] = d.get(s[i], 0) + 1
                if isSame(d.values()):
                    ml = max(ml, sum(d.values()))
            p += 1
            d = {}
        return ml