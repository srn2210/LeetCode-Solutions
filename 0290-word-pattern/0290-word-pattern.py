class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        m1 = dict()
        m2 = dict()
        st = s.split(" ")
        j = 0
        if len(st) != len(pattern): return False
        for i in pattern:
            if i in m1:
                if m1[i] != st[j]: return False
            if st[j] in m2:
                if m2[st[j]] != i: return False
            m1[i] = st[j]
            m2[st[j]] = i
            j += 1
        return True