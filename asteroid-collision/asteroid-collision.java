class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var st = new ArrayDeque<Integer>();
        for(int i : asteroids) {
            if(st.isEmpty()) st.push(i);
            else if(!st.isEmpty()) {
                if(st.peek() < 0) {
                    st.push(i);
                }
                else {
                    if(i > 0) st.push(i);
                    else {
                        while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)) {
                            st.pop();
                        }
                        if(!st.isEmpty() && st.peek() > 0 && st.peek() ==  Math.abs(i)) st.pop();
                        else if(!st.isEmpty() && st.peek() < 0) st.push(i);
                        else if(st.isEmpty()) st.push(i);
                    }
                }
            }
        }
        int[] ans = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()) ans[i--] = st.pop();
        return ans;
    }
}