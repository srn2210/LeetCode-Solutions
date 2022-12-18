class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = deque()
        res = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            if st and temperatures[st[-1]] >= temperatures[i]:
                st.append(i)
            elif st:
                while st and temperatures[st[-1]] < temperatures[i]:
                    res[st[-1]] = i - st[-1]
                    st.pop()
                st.append(i)
            else:
                st.append(i)
        return res