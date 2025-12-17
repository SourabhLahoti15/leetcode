# Last updated: 12/17/2025, 10:52:21 AM
class Solution(object):
    def distributeCandies(self, candyType):
        """
        :type candyType: List[int]
        :rtype: int
        """
        d = {}
        n = len(candyType)
        for i in candyType:
            d[i] = d.get(i, 0) + 1
        if len(d.keys()) >= n/2:
            return n/2
        else:
            return len(d.keys())
            