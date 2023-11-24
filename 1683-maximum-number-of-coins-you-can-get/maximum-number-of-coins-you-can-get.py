from sortedcontainers import SortedList
class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        sl = SortedList(piles)
        ans = 0
        while sl:
            sl.pop()
            ans += sl.pop()
            sl.pop(0)

        return ans

