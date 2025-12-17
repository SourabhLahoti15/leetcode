# Last updated: 12/17/2025, 10:53:43 AM
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        slist = s.split()
        revslist = slist[::-1]
        revs = " ".join(revslist)
        return revs
        