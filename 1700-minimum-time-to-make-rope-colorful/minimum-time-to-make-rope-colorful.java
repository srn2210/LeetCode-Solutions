class Solution {
    public int minCost(String colors, int[] neededTime) {
        var st = new Stack<Integer>();
        st.push(0);
        int ans = 0;
        for(int i=1; i<colors.length(); i++) {
            if(colors.charAt(i) == colors.charAt(st.peek())) {
                if(neededTime[st.peek()] < neededTime[i]) {
                    ans += neededTime[st.pop()];
                    st.push(i);
                }
                else {
                    ans += neededTime[i];
                }
            }
            else st.push(i);
        }
        return ans;
    }
}