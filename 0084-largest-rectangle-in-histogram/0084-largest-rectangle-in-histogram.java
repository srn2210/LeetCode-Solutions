class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0, min = Integer.MAX_VALUE;
        var st = new Stack<Integer>();
        
        for(int i=0; i<heights.length; i++) {
            if(st.isEmpty() || heights[st.peek()] <= heights[i]) st.push(i);
            else {
                int og = st.peek();
                while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                    int t = st.pop();
                    if(!st.isEmpty()) ans = Math.max(ans, heights[t] * (og - st.peek()));
                    else ans = Math.max(ans, heights[t] * (og + 1));
                    
                }
                st.push(i);
            }
        }
        int og = st.peek();
        while(!st.isEmpty()) {
            int t = st.pop();
            if(!st.isEmpty()) ans = Math.max(ans, heights[t] * (og - st.peek()));
            else ans = Math.max(ans, heights[t] * (og + 1));
        }
        
        return ans;
    }
}