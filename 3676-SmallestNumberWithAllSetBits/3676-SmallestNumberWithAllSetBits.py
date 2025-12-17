# Last updated: 12/17/2025, 10:50:58 AM
class Solution(object):
    def smallestNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        i = 0
        while True:
            if (2**i)-1 >= n:
                return (2**i)-1
            i += 1
                  

