# Last updated: 12/17/2025, 10:52:49 AM
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
        slist = list(s)
        i = 0
        j = len(slist) - 1
        while i<j:
            while slist[i] not in vowels and i<j:
                i += 1
            while slist[j] not in vowels and i<j:
                j -= 1
            temp = slist[i]
            slist[i] = slist[j]
            slist[j] = temp
            i += 1
            j -= 1
        return "".join(slist)