# Last updated: 12/17/2025, 10:51:25 AM
class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        numEmpty = 0
        consume = 0
        while numBottles>0:
            consume+=numBottles
            numEmpty+=numBottles
            numBottles=0
            numBottles = numEmpty//numExchange
            numEmpty = numEmpty%numExchange
        return consume


        