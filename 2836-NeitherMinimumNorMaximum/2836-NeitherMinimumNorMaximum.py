# Last updated: 12/17/2025, 10:51:07 AM
class Solution(object):
    def findNonMinOrMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxi = max(nums)
        mini = min(nums)
        for i in nums:
            if i != maxi and i != mini:
                return i
        return -1
        