# Last updated: 12/17/2025, 10:52:27 AM
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in range(len(nums)):
            j = (i+1)%len(nums)
            while j != i:
                j = j%len(nums)
                if nums[j]>nums[i]:
                    ans.append(nums[j])
                    break
                j = (j+1)%len(nums)
            if j==i:
                ans.append(-1)
        return ans
