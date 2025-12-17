# Last updated: 12/17/2025, 10:53:36 AM
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d = {}
        for i in nums:
            if i in d:
                d[i] += 1
            else: 
                d[i] = 1
        m_value = d.values()[0]
        m_key = d.keys()[0]
        for k, v in d.items():
            if v>=m_value:
                m_key = k
                m_value = v
        return m_key