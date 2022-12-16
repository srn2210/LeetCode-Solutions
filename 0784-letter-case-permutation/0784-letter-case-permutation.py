class Solution:
    def backtrack(self, s: List[str], res: List[str], j: int) -> None:
        res.append("".join(s))
        for i in range(j, len(s)):
            if s[i].islower():
                s[i] = s[i].upper()
                self.backtrack(s, res, i+1)
                s[i] = s[i].lower()
            elif s[i].isupper():
                s[i] = s[i].lower()
                self.backtrack(s, res, i+1)
                s[i] = s[i].upper()
    def letterCasePermutation(self, s: str) -> List[str]:
        res = []
        s1 = [i for i in s]
        self.backtrack(s1, res, 0)
        return res