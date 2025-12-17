# Last updated: 12/17/2025, 10:52:31 AM
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        boolarr = [False] * n
        for i in nums:
            boolarr[i-1] = True
        ans = []
        for b in range(len(boolarr)):
            if boolarr[b] == False:
                ans.append(b+1)
        return ans
        