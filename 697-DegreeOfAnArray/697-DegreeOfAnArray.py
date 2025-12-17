# Last updated: 12/17/2025, 10:52:09 AM
class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        m = max(d.values())
        maxearr = []
        for k, v in d.items():
            if v == m:
                maxearr.append(k)
        sublenarr = []
        for maxele in maxearr:
            for i in range(len(nums)):
                if nums[i] == maxele:
                    s = i
                    break
            for i in range(len(nums)-1, -1,-1):
                if nums[i] == maxele:
                    e = i
                    break
            sublenarr.append(e-s+1)
        return min(sublenarr)

            

        