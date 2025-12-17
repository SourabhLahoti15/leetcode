# Last updated: 12/17/2025, 10:54:20 AM
class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = list(set(nums))
        nums.sort()
        n = len(nums)
        pidx = -1
        i = 0
        while i < n:
            if nums[i] > 0:
                pidx = i
                break
            i += 1
        if i == n:
            return 1
        val = 1
        for i in range(pidx, n):
            if (nums[i] == val):
                val += 1
            else:
                return val
        return val

            
