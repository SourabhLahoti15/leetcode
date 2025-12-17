# Last updated: 12/17/2025, 10:54:43 AM
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        strx = str(x)
        revstrx = "".join(reversed(strx))
        return strx == revstrx