# Last updated: 12/17/2025, 10:52:56 AM
class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        s_arr = s.split()
        d = {}
        if len(s_arr) != len(pattern):
            return False
        for i in range(len(pattern)):
            if pattern[i] in d.keys():
                if d[pattern[i]] == s_arr[i]:
                    continue
                else:
                    return False
            else:
                key = [k for k, v in d.items() if v == s_arr[i]]
                if key and key!=pattern[i]:
                    return False
                else:
                    d[pattern[i]] = s_arr[i]

        return True


        