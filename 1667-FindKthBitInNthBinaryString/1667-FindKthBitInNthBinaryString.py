# Last updated: 12/17/2025, 10:51:24 AM
class Solution(object):
    def findKthBit(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        def reverse(s):
            return s[::-1]

        def invert(s):
            rs = ""
            for c in s:
                if c == "0":
                    rs += "1"
                else:
                    rs += "0"
            return rs

        s = ["0"]
        for i in range(2, n+1):
            s.append(s[i-2] + "1" + reverse(invert(s[i-2])))
        return s[len(s)-1][k-1]