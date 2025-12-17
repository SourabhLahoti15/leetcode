# Last updated: 12/17/2025, 10:51:09 AM
class Solution(object):
    def capitalizeTitle(self, title):
        """
        :type title: str
        :rtype: str
        """
        titlewords = title.split()
        ans = []
        for word in titlewords:
            if len(word) <= 2:
                ans.append(word.lower())
            else:
                ans.append(word.capitalize())
        return " ".join(ans)
        