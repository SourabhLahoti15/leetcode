# Last updated: 12/17/2025, 10:54:25 AM
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        k = -1
        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                k = i+1
                break
        n = len(nums)
        if k==-1:
            k=0
        rotated = nums[k:n] + nums[0:k]
        
        l = 0
        r = len(rotated)-1
        while l<=r:
            mid = l + (r-l)//2 
            if rotated[mid] == target:
                return (mid+k)%n
            elif rotated[mid] > target:
                r = mid-1
            else:
                l = mid+1
        return -1