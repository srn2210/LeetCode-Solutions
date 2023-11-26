class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        st = deque()
        n = len(heights)
        ans = -1

        for i, h in enumerate(heights):
            while st and heights[st[-1]] > h:
                prev = -1
                t = st.pop()
                if st:
                    prev = st[-1]
                ans = max(ans, heights[t] * (i - prev - 1))
            
            st.append(i)
        
        while st:
            prev = -1
            t = st.pop()
            if st:
                prev = st[-1]
            ans = max(ans, heights[t] * (n - prev - 1))
        
        return ans