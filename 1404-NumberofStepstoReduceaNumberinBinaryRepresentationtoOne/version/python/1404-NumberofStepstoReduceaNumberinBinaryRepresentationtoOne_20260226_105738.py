# Last updated: 2/26/2026, 10:57:38 AM
1class Solution(object):
2    def numSteps(self, s):
3        """
4        :type s: str
5        :rtype: int
6        """
7        num = int(s, 2)
8        steps = 0
9        while (num != 1):
10            if (num % 2 == 0):
11                num = num / 2
12            else:
13                num = num + 1
14            steps += 1
15        return steps