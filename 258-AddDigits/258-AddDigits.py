# Last updated: 12/17/2025, 10:53:05 AM
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        s_num = str(num)
        if len(s_num)==1:
            return num
        else:
            ans = 0
            while len(str(num))>1:
                ans = 0
                s_num = str(num)
                for i in s_num:
                    ans += int(i)
                num = ans
            return ans
