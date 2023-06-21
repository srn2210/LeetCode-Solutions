class Solution {
    void reverse(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        var st = new Stack<Integer>();
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
        int i = 0;
        while(!st.isEmpty()) ans[i++] = st.pop();
        reverse(ans);
        return ans;
    }
}