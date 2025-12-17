# Last updated: 12/17/2025, 10:51:05 AM
class Solution(object):
    def numberOfSpecialChars(self, word):
        """
        :type word: str
        :rtype: int
        """
        count = 0
        wordlist = list(word)
        for c in word:
            if c.islower():
                continue
            else:
                if c.lower() in wordlist:
                    count += 1
                    wordlist = [x for x in wordlist if x != c.lower()]
        return count
