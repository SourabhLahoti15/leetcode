# Last updated: 12/17/2025, 10:52:38 AM
class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s)==0:
            return True
        if len(s)!=0 and len(t)==0:
            return False
        
        jidx = 0
        for i in range(len(s)):
            for j in range(jidx, len(t)):
                jidx = j+1
                if i!=len(s)-1 and j==len(t)-1:
                    return False
                if s[i]==t[j]:
                    if i==len(s)-1:
                        return True
                    break
                if j==len(t)-1:
                    return False                    