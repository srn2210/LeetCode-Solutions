class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = deque()
        res = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            if st and st[-1][0] >= temperatures[i]:
                st.append([temperatures[i], i])
            elif st:
                while st and st[-1][0] < temperatures[i]:
                    temp = st.pop()
                    res[temp[1]] = i - temp[1]
                st.append([temperatures[i], i])
            else:
                st.append([temperatures[i], i])
        return res