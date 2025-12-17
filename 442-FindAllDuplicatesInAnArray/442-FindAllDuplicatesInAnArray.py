# Last updated: 12/17/2025, 10:52:32 AM
class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for i in nums:
            idx = abs(i) - 1
            if nums[idx] < 0:
                res.append(abs(i))
            else:
                nums[idx] *= -1
        return res