class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var st = new ArrayDeque<Integer>();
        for(int i=0; i<asteroids.length; i++) {
            int curr = asteroids[i];
            if(!st.isEmpty() && st.peek() > 0 && curr < 0) {
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(curr)) st.pop();
                if(!st.isEmpty() && st.peek() > 0) {
                    if(Math.abs(st.peek()) == Math.abs(curr)) st.pop();
                }
                else st.push(curr);
            }
            else st.push(curr);
        }
        int[] ans = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()) ans[i--] = st.pop();
        return ans;
    }
}