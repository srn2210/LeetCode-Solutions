class Solution {
    public int trap(int[] height) {
        var st = new ArrayDeque<Integer>();
        int ans = 0;
        for(int i=0; i<height.length; i++) {
            if(st.isEmpty() || height[i] < height[st.peekLast()]) st.addLast(i);
            else {
                //int t = Math.min(height[i], height[st.peekFirst()]);
                while(!st.isEmpty() && height[i] > height[st.peekLast()]) {
                    int prev = st.removeLast();
                    if(st.isEmpty()) continue;
                    int t = Math.min(height[i], height[st.peekLast()]);
                    int temp = (i - st.peekLast() - 1) * (t - height[prev]);
                    ans += temp;
                    //System.out.println(i + "  " + st.peekLast() + "  " + (i - st.peekLast() - 1) + "  " + ( t - height[prev]) + "  " + temp);
                    //ans += (i - st.peekLast()) * (t - height[st.pollLast()]);
                }
                st.addLast(i);
            }
        }
        return ans;
    }
}