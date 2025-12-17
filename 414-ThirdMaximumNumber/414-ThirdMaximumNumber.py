# Last updated: 12/17/2025, 10:52:36 AM
class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = list(set(nums))
        if len(nums)<3:
            return max(nums)
        nums.sort()
        return nums[len(nums)-3]