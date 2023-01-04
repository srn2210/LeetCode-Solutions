class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        arr = [0 for i in range(n+1)]
        for num in citations:
            if num >= n:
                arr[n] += 1
            else:
                arr[num] += 1
        ans = 0
        for i in reversed(range(n+1)):
            ans += arr[i]
            if ans >= i:
                return i
        return 0