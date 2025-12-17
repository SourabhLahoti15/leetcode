# Last updated: 12/17/2025, 10:53:39 AM
class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        vl1 = version1.split(".")
        vl2 = version2.split(".") 

        nv1 = len(vl1)
        nv2 = len(vl2)

        if nv1 == nv2:
            for i in range(len(vl1)):
                if int(vl1[i]) > int(vl2[i]):
                    return 1
                elif int(vl1[i]) < int(vl2[i]):
                    return -1
                else:
                    continue
            return 0        

        
        if nv1 > nv2:
            longv = nv1
        else:
            longv = nv2
        
        for i in range(longv):
            if i >= nv1:
                vl1 += "0"
            if i >= nv2:
                vl2 += "0"
            if int(vl1[i]) > int(vl2[i]):
                    return 1
            elif int(vl1[i]) < int(vl2[i]):
                return -1
            else:
                continue
        return 0
        





        