# Last updated: 12/17/2025, 10:52:40 AM
from collections import Counter
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """

        dic = {}
        for c in s:
            if c in dic:
                dic[c]+=1
            else:
                dic[c] = 1
        for i in range(len(s)):
            if dic[s[i]]==1:
                return i
        return -1

        # for i in range(len(s)):
        #     found=False
        #     for j in range(len(s)):
        #         if found==True:
        #             break
        #         if i==j:
        #             continue
        #         elif s[i]!=s[j]:
        #             found=False
        #         elif s[i]==s[j]:
        #             found=True
        #     if found==False:
        #         return i
        # return -1

        # counter = Counter(s)
        # for i in range(len(s)):
        #     if counter[s[i]]==1:
        #         return i
        # return -1
        

        