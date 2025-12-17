# Last updated: 12/17/2025, 10:51:01 AM
class Solution(object):
    def getSneakyNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        l = []
        for k, v in d.items():
            if v == 2:
                l.append(k)
        return l