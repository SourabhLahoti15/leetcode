# Last updated: 12/17/2025, 10:51:57 AM
class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        slist = []
        tlist = []
        for i in s:
            if i != "#":
                slist.append(i)
            else:
                if len(slist) != 0:
                    slist.pop()
        for i in t:
            if i != "#":
                tlist.append(i)
            else:
                if len(tlist) != 0:
                    tlist.pop()
        return "".join(slist) == "".join(tlist)
        