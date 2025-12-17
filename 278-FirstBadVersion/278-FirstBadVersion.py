# Last updated: 12/17/2025, 10:53:00 AM
# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        s = 1
        e = n
        while s<e:
            if e == s + 1:
                if isBadVersion(s):
                    return s
                else:
                    return e
            mid = s + (e-s)/2            
            if isBadVersion(mid):
                if not(isBadVersion(mid-1)):
                    return mid
                e = mid
            else:
                s = mid
        return 1
        