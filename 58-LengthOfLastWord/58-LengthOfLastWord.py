# Last updated: 12/17/2025, 10:54:10 AM
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        arr = s.split()
        last_word = arr[-1]
        return len(last_word)
        