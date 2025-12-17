# Last updated: 12/17/2025, 10:51:00 AM
class Solution(object):
    def hasIncreasingSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        def isStrictlyIncreasing(i, k):
            j = i+1
            while k>1:
                if nums[i]>=nums[j]:
                    return False
                k -= 1
                i += 1
                j = i+1
            return True
        for i in range(len(nums)-2*k+1):
            if isStrictlyIncreasing(i, k):
                if isStrictlyIncreasing(i+k, k):
                    return True
        return False