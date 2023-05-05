class Solution {
    int ans;
    void updateStack(Deque<Integer> st, int[] heights, int num) {
        int og = st.peekLast();
        while(!st.isEmpty() && heights[st.peekLast()] > num) {
            int t = st.removeLast();
            if(!st.isEmpty()) ans = Math.max(ans, heights[t] * (og - st.peekLast()));
            else ans = Math.max(ans, heights[t] * (og + 1));
                    
        }
    }
    public int largestRectangleArea(int[] heights) {
        ans = 0;
        var st = new ArrayDeque<Integer>();
        
        for(int i=0; i<heights.length; i++) {
            if(st.isEmpty() || heights[st.peekLast()] <= heights[i]) st.addLast(i);
            else {
                updateStack(st, heights, heights[i]);
                st.addLast(i);
            }
        }
        updateStack(st, heights, 0);
        
        return ans;
    }
}