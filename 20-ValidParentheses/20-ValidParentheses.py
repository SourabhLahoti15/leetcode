# Last updated: 12/17/2025, 10:54:37 AM
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s)%2!=0:
            return False
        arr = []
        for p in s:
            if p=="(" or p=="[" or p=="{":
                arr.append(p)
            elif len(arr)==0 and (p==")" or p=="]" or p=="}"):
                return False
            else:
                top = arr.pop()
                if (top=="(" and p==")") or (top=="[" and p=="]") or (top=="{" and p=="}"):
                    continue
                else:
                    return False
        if len(arr)==0:
            return True
        else:
            return False

        