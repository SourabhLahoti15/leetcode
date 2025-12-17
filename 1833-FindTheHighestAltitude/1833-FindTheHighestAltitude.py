# Last updated: 12/17/2025, 10:51:20 AM
class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        l=[]
        s=0
        l.append(s)
        for i in gain:
            s+=i
            l.append(s)
        m=l[0]
        for i in l:
            if i>m:
                m=i
        return m
