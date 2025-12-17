# Last updated: 12/17/2025, 10:51:06 AM
class Solution(object):
    def maxFrequencyElements(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mydict = {}
        for i in nums:
            if i in mydict.keys():
                mydict[i] += 1
            else:
                mydict[i] = 1
        arr = mydict.values()
        m = arr[0]
        for i in arr:
            if i>m:
                m=i
        count = 0
        for i in arr:
            if i==m:
                count+=m
        return count
        