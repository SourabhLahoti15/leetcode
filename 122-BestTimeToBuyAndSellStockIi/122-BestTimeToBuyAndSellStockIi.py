# Last updated: 12/17/2025, 10:53:48 AM
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxsell = -1
        profit = 0
        for buy in range(len(prices)):
            for sell in range(buy+1, len(prices)):
                if prices[buy] < prices[sell]:
                    profit += prices[sell]-prices[buy]
                    break
                else:
                    break
        return profit

        