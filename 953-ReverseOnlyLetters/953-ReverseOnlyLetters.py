# Last updated: 12/17/2025, 10:51:53 AM
class Solution(object):
    def reverseOnlyLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        l = 0
        h = len(s)-1
        lis = list(s)
        while l<h:
            while not((s[l]).isalpha()) and l<h:
                l += 1
            while not((s[h]).isalpha()) and l<h:
                h -= 1
            temp = lis[l]
            lis[l] = lis[h]
            lis[h] = temp
            l += 1
            h -= 1
        return "".join(lis)
                
        