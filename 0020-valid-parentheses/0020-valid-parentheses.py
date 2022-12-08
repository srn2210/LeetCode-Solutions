class Solution:
    def isValid(self, s: str) -> bool:
        st = deque()
        for ch in s:
            if st and st[-1] == '(' and ch == ')': st.pop()
            elif st and st[-1] == '[' and ch == ']': st.pop()
            elif st and st[-1] == '{' and ch == '}': st.pop()
            else: st.append(ch)
        return True if len(st) == 0 else False