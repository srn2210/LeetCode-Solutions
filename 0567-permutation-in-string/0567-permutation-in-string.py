class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        count = [0 for i in range(26)]
        for ch in s1: count[ord(ch) - ord('a')] += 1
        left = 0
        right = 0
        while right < len(s2):
            if count[ord(s2[right]) - ord('a')] > 0:
                count[ord(s2[right]) - ord('a')] -= 1
                if right - left + 1 == len(s1): return True
                right += 1
            else:
                count[ord(s2[left]) - ord('a')] += 1
                left += 1
        return False