class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        i = len(g) - 1
        j = len(s) - 1
        count = 0
        while i >= 0 and j >= 0:
            if g[i] <= s[j]:
                count += 1
                i -= 1
                j -= 1
            else:
                i -= 1
        return count