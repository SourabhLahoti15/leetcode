# Last updated: 12/17/2025, 10:54:07 AM
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            j=i+1
            while j<len(nums):
                if nums[j]<nums[i]:
                    nums[i], nums[j] = nums[j], nums[i]
                j+=1
        return nums