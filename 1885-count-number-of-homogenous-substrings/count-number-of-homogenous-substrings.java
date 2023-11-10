class Solution {
    public int countHomogenous(String s) {
        int mod = (int)1e9+7;
        char present = s.charAt(0);
        int left = 0, right = 0;
        int ans = 0;
        while(right < s.length()) {
            char curr = s.charAt(right);
            if(curr == present) right++;
            else {
                long len = right - left;
                len = (len * (len+1)) / 2;
                len %= mod;
                ans += (int) len;
                left = right;
                present = curr;
            }
        }
        if(left != right) {
            long len = right - left;
            len = (len * (len+1)) / 2;
            len %= mod;
            ans += (int) len;
            left = right;
        }
        return ans;
    }
}