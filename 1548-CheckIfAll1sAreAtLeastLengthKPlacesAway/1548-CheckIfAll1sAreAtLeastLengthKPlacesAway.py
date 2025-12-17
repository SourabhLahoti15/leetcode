# Last updated: 12/17/2025, 10:51:32 AM
class Solution(object):
    def kLengthApart(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        i = 0
        n = len(nums)
        while i < n:
            if nums[i] == 1:
                j = i + 1
                while j < n:
                    if nums[j] == 1:
                        if j - i - 1 < k:
                            return False
                        else:
                            i = j - 1
                            break
                    j += 1
            i += 1
        return True

        