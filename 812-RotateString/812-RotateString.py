# Last updated: 12/17/2025, 10:52:00 AM
class Solution(object):
    def rotateString(self, s, goal):
        """
        :type s: str
        :type goal: str
        :rtype: bool
        """
        for i in range(len(s)):
            s = s[-1] + s[:-1]
            if s == goal:
                return True
        return False