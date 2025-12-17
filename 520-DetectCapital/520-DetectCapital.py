# Last updated: 12/17/2025, 10:52:25 AM
class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        count = 0
        for c in word:
            if c.isupper():
                count += 1
        if count == 1 and word[0].isupper():
            return True
        elif count == len(word):
            return True
        elif count == 0:
            return True
        else:
            return False

        
        