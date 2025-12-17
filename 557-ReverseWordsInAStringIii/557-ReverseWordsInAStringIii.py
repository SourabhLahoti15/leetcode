# Last updated: 12/17/2025, 10:52:23 AM
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        answords = []
        swords = s.split()
        for word in swords:
            answords.append(word[::-1])
        return " ".join(answords)