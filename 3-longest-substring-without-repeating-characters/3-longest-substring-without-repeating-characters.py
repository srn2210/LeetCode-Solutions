class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #if len(s) == 0: return 0
        ans = 0
        left = 0
        right = 0
        
        hs = set()
        
        while(right < len(s)):
            if s[right] in hs:
                hs.remove(s[left])
                left += 1
            else:
                hs.add(s[right])
                ans = max(ans, right-left+1)
                right += 1
        
        return ans