# Last updated: 12/17/2025, 10:50:52 AM
class Solution(object):
    def decimalRepresentation(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        p=0
        arr = []
        while n>0:
            ld = (n%10) * 10**p
            n = n//10
            if ld!=0:
                arr.append(ld)
            p += 1
        ansarr = arr[::-1]
        return ansarr
            
            