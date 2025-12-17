# Last updated: 12/17/2025, 10:50:53 AM

class Solution(object):
    def gcdOfOddEvenSums(self, n):
        sumOdd = 0
        sumEven = 0
        # for i in range(1, n+1):
        #     if i%2 == 0:
        #         sumEven += i
        #     elif i%2 != 0:
        #         sumOdd += i
        i=0
        num=1
        while i!=n:
            if num%2!=0:
                sumOdd += num
            i += 1
        i=0
        num=1
        while i!=n:
            if num%2==0:
                sumEven += num
            i += 1
        maximum = sumOdd if sumOdd > sumEven else sumEven
        a = maximum
        b = (sumOdd+sumEven) - maximum
        while b!=0:
            temp = b
            b = a%b
            a = temp
        return a
        