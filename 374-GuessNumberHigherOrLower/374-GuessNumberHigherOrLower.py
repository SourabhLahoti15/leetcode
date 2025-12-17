# Last updated: 12/17/2025, 10:52:43 AM
# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        s = 1
        e = n
        while s<e:
            if e == s+1:
                if guess(s) == 0:
                    return s
                else:
                    return e
            mid = (s+e)/2
            g = guess(mid)
            if g == 0:
                return mid
            elif g == -1:
                e = mid -1
            elif g == 1:
                s = mid +1
        if s == e:
            return s

        