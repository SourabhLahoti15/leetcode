# Last updated: 12/17/2025, 10:52:03 AM
class Solution(object):
    def numJewelsInStones(self, jewels, stones):
        """
        :type jewels: str
        :type stones: str
        :rtype: int
        """
        count = 0
        for c in stones:
            if c in jewels:
                count += 1
        return count
        