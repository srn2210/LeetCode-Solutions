class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        mod = int(1e9+7)
        ans = 0
        diffMap = defaultdict(int)

        def reverse(num):
            cpy = num
            rev = 0

            while num:
                rev = (rev * 10) + num % 10
                num //= 10
            
            diff = cpy - rev

            diffMap[diff] += 1

        for num in nums:
            reverse(num)
        
        for val in diffMap.values():
            if val <= 1:
                continue
            
            ans += (val * (val - 1)) // 2
            ans %= mod

        return ans
        