class Solution:
    def check(self, ch: str) -> bool :
        if ch.isupper() : ch = ch.lower()
        return ch == 'a' or ch == 'e' or ch == 'i' or ch == 'o' or ch == 'u'
    def halvesAreAlike(self, s: str) -> bool:
        ans = 0
        for i, ch in enumerate(s) :
            if i < len(s)//2 and self.check(ch): ans += 1
            if i >= len(s)//2 and self.check(ch): ans -= 1
        return ans == 0
        