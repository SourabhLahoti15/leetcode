# Last updated: 12/17/2025, 10:52:45 AM
import math
class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        odd = 1
        while num>0:
            num -= odd
            odd += 2
        return num == 0