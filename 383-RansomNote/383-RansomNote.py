# Last updated: 12/17/2025, 10:52:42 AM
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        magazineletters = list(magazine)
        for i in ransomNote:
            if i in magazineletters:
                magazineletters.remove(i)
            else:
                return False
        return True