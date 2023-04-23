class Solution {
    public int trap(int[] height) {
        var st = new LinkedList<Integer>();
        int ans = 0;
        for(int i=0; i<height.length; i++) {
            while(!st.isEmpty() && height[i] > height[st.peekLast()]) {
                int prev = st.removeLast();
                if(st.isEmpty()) continue;
                ans += (i - st.peekLast() - 1) * (Math.min(height[i], height[st.peekLast()]) - height[prev]);
            }
            st.addLast(i);
        }
        return ans;
    }
}