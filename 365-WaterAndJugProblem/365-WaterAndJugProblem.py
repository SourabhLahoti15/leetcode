# Last updated: 12/17/2025, 10:52:44 AM
import fractions
class Solution(object):
    def canMeasureWater(self, x, y, target):
        """
        :type x: int
        :type y: int
        :type target: int
        :rtype: bool
        """
        if target == 0:
            return True 
        return (x+y >= target) and (target % fractions.gcd(x, y) == 0)               
