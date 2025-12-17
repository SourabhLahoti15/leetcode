# Last updated: 12/17/2025, 10:51:58 AM
import string
class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        banned = [b.lower() for b in banned]

        paragraph = paragraph.replace("!", " ")
        paragraph = paragraph.replace("?", " ")
        paragraph = paragraph.replace("'", " ")
        paragraph = paragraph.replace(",", " ")
        paragraph = paragraph.replace(";", " ")
        paragraph = paragraph.replace(".", " ")
        words = paragraph.split()

        d = {}

        for word in words:
            word = word.lower()
            d[word] = d.get(word, 0) + 1
        sorted_d = dict(sorted(d.items(), key=lambda x: x[1], reverse=True))
        for k in sorted_d.keys():
            if k not in banned:
                return k