# Last updated: 12/17/2025, 10:51:28 AM
class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l=[]
        s=0
        for i in nums:
            s+=i
            l.append(s)
        return l
        