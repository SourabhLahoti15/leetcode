# Last updated: 12/17/2025, 10:50:49 AM
class Solution(object):
    def alternatingSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        flag = 1
        sum = 0
        for i in nums:
            if flag:
                sum += i
                flag = not(flag)
            else:
                sum -= i
                flag = not(flag)
        return sum
            
            
        