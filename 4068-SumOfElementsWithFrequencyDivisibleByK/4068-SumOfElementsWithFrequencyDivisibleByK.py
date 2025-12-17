# Last updated: 12/17/2025, 10:50:48 AM
class Solution(object):
    def sumDivisibleByK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        d = {}
        for i in nums:
            d[i] = d.get(i, 0) + 1
        sum = 0
        for key, val in d.items():
            if val%k==0:
                sum += key*val
        return sum