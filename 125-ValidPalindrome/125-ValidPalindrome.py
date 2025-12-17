# Last updated: 12/17/2025, 10:53:46 AM
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        converted_string = ""
        for i in s:
            if i.isalnum():
                converted_string += i.lower()
        if converted_string == converted_string[::-1]:
            return True
        else: 
            return False
        