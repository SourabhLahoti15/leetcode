# Last updated: 12/17/2025, 10:52:07 AM
class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        def check(n):
            on = n
            while n>0:
                ld = n%10
                if ld == 0:
                    return False
                if on % ld != 0:
                    return False
                n = n // 10
            return True
        ans = []
        for i in range(left, right + 1):
            if check(i):
                ans.append(i)
        return ans

