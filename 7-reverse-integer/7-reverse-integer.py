class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            mul = -1
            x = -x
        else:
            mul = 1
        ans = 0
        while(x != 0):
            top = x % 10
            x = x//10
            ans = ans * 10 + top
        if ans > pow(2,31) or ans < pow(2,-31): return 0
        return ans * mul