class Solution:
    def myAtoi(self, s: str) -> int:
        j = 0
        for i in range(len(s)):
            if s[i] == " ": continue
            else:
                j = i
                break
        sign = 1
        if j < len(s) and s[j] == "-":
            sign = -1
            j += 1
        elif j < len(s) and s[j] == "+":
            j += 1
        ans = 0
        for i in range(j, len(s)):
            if s[i].isdigit():
                ans = ans * 10 + ord(s[i]) - ord('0')
            else: break
        ans = ans * sign
        if ans > (2 ** 31) - 1: ans = 2 ** 31 - 1
        if ans < (-2 ** 31): ans = -2 ** 31
        return ans