from sortedcontainers import SortedList
class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        dq = deque(piles)
        ans = 0
        while dq:
            dq.pop()
            ans += dq.pop()
            dq.popleft()

        return ans

