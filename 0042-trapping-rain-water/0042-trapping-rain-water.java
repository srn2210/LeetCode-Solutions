class Solution {
    public int trap(int[] height) {
        var st = new Stack<Integer>();
        int ans = 0;
        for(int i=0; i<height.length; i++) {
            if(st.isEmpty() || height[i] < height[st.peek()]) st.push(i);
            else {
                while(!st.isEmpty() && height[i] > height[st.peek()]) {
                    int prev = st.pop();
                    if(st.isEmpty()) continue;
                    int t = Math.min(height[i], height[st.peek()]);
                    int temp = (i - st.peek() - 1) * (t - height[prev]);
                    ans += temp;
                }
                st.push(i);
            }
        }
        return ans;
    }
}