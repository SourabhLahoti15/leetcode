# Last updated: 12/17/2025, 10:52:28 AM
class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in nums1:
            idx = nums2.index(i)
            if idx==len(nums2)-1:
                ans.append(-1)
            else:
                for j in range(idx+1, len(nums2)):
                    if nums2[j]>i:
                        ans.append(nums2[j])
                        break
                    if j==len(nums2)-1:
                        ans.append(-1)
        return ans


        