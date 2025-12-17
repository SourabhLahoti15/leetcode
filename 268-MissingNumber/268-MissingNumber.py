# Last updated: 12/17/2025, 10:53:06 AM
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = [0]*(len(nums)+1)
        for i in nums:
            l[i]=1
        for i in range(len(l)):
            if l[i]==0:
                return i   