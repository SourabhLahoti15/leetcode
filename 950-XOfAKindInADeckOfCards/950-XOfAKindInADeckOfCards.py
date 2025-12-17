# Last updated: 12/17/2025, 10:51:54 AM
import fractions
from functools import reduce

class Solution(object):
    def hasGroupsSizeX(self, deck):
        """
        :type deck: List[int]
        :rtype: bool
        """
        d = {}
        for i in deck:
            d[i] = d.get(i, 0) + 1
        gcd = reduce(fractions.gcd, d.values())
        if gcd <= 1:
            return False
        for i in d.values():
            if i % gcd != 0:
                return False
        return True
