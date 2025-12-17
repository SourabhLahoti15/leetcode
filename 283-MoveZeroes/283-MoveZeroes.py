# Last updated: 12/17/2025, 10:52:58 AM
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            if nums[i] != 0:
                continue
            else:
                nonzeroidx = -1
                for j in range(i+1, len(nums)):
                    if nums[j] != 0:
                        nonzeroidx = j
                        break
                if nonzeroidx != -1:
                    nums[i] = nums[nonzeroidx]
                    nums[nonzeroidx] = 0
                else:
                    break