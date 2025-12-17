# Last updated: 12/17/2025, 10:53:01 AM
class Solution(object):
    def isUgly(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n<=0:
            return False
        for factor in (2, 3, 5):
            while n%factor == 0:
                n = n/factor
        return n == 1