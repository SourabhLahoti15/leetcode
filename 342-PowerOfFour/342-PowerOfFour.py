# Last updated: 12/17/2025, 10:52:52 AM
class Solution(object):
    def isPowerOfFour(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return False
        while n%4 == 0:
            n = n/4
        return n == 1
        