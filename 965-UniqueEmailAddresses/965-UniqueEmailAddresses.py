# Last updated: 12/17/2025, 10:51:52 AM
class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        d = {}
        for email in emails:
            emaildomain = email.split("@")

            email = emaildomain[0]
            email = email.split("+")[0]
            email = "".join(email.split("."))

            domain = emaildomain[1]

            if domain not in d:
                d[domain] = []
            if email not in d[domain]:
                d[domain].append(email)

        count = 0
        for k, v in d.items():
            count += len(v)
        return count
