class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        ans = []

        for i in range(len(l)):
            curr = set()
            mini = int(1e9)
            maxi = int(-1e9)
            for j in range(l[i], r[i]+1):
                curr.add(nums[j])
                mini = min(mini, nums[j])
                maxi = max(maxi, nums[j])
            
            diff = (maxi - mini) / (r[i] - l[i])
            if diff % 1 != 0:
                ans.append(False)
                continue
            
            start = mini
            flag = True
            for i in range(r[i]-l[i]+1):
                if start not in curr:
                    flag = False
                    break
                start += diff

            ans.append(flag)
        
        return ans