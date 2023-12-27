class Solution {
    public int minCost(String colors, int[] neededTime) {
        var st = new ArrayDeque<Integer>();
        int ans = 0;
        for(int i=0; i<colors.length(); i++) {
            if(!st.isEmpty() && colors.charAt(i) == colors.charAt(st.peek())) {
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