class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0, min = Integer.MAX_VALUE;
        var st = new ArrayDeque<Integer>();
        
        for(int i=0; i<heights.length; i++) {
            if(st.isEmpty() || heights[st.peekLast()] <= heights[i]) st.addLast(i);
            else {
                int og = st.peekLast();
                while(!st.isEmpty() && heights[st.peekLast()] > heights[i]) {
                    int t = st.removeLast();
                    if(!st.isEmpty()) ans = Math.max(ans, heights[t] * (og - st.peekLast()));
                    else ans = Math.max(ans, heights[t] * (og + 1));
                    
                }
                st.addLast(i);
            }
        }
        int og = st.peekLast();
        while(!st.isEmpty()) {
            int t = st.removeLast();
            if(!st.isEmpty()) ans = Math.max(ans, heights[t] * (og - st.peekLast()));
            else ans = Math.max(ans, heights[t] * (og + 1));
        }
        
        return ans;
    }
}