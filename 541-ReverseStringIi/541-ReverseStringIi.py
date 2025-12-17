# Last updated: 12/17/2025, 10:52:24 AM
class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if len(s) < k:
            return s[::-1]
        i = 0
        while i<len(s):
            s = s[:i] + s[i:i+k][::-1] + s[i+k:]
            i += 2*k
        return s