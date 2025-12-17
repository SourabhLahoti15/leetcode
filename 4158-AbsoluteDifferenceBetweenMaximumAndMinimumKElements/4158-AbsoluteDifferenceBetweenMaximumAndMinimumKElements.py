# Last updated: 12/17/2025, 10:50:41 AM
class Solution(object):
    def absDifference(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        sortnums = sorted(nums)
        l = sortnums[0 : k]
        lsum = 0
        for i in l:
            lsum += i
        
        r = sortnums[len(nums)-k : len(nums)]
        rsum = 0
        for i in r:
            rsum += i
            
        return abs(rsum-lsum)