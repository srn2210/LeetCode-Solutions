class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        hmap = defaultdict(int)
        mini = 1e9
        maxi = -1e9
        for num in nums:
            hmap[num] += 1
            mini = min(mini, num)
            maxi = max(maxi, num)
        ind = 0
        for i in range(mini, maxi+1):
            if i in hmap:
                while hmap[i]:
                    nums[ind] = i
                    hmap[i] -= 1
                    ind += 1
        return nums