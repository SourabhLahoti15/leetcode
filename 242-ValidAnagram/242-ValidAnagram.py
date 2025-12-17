# Last updated: 12/17/2025, 10:53:07 AM
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        sfreq = {}
        tfreq = {}
        for c in s:
            sfreq[c] = sfreq.get(c, 0)+1
        for c in t:
            tfreq[c] = tfreq.get(c, 0)+1
        
        for c in s:
            if sfreq.get(c)!=tfreq.get(c):
                return False
        return True

        