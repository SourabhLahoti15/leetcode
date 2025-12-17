# Last updated: 12/17/2025, 10:54:01 AM
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        zeroidx = []
        for row in range(len(matrix)):
            if 0 in matrix[row]:
                for i in range(len(matrix[row])):
                    if matrix[row][i] == 0:
                        zeroidx.append(i)
                    matrix[row][i] = 0
        for zi in zeroidx:
            for row in range(len(matrix)):
                matrix[row][zi] = 0
        return matrix
