# Last updated: 12/17/2025, 10:54:15 AM
from collections import Counter
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        grps = {}
        for word in strs:
            arrangeword = tuple(sorted(word))
            if arrangeword not in grps:
                grps[arrangeword] = []
            grps[arrangeword].append(word)
        return list(grps.values())        