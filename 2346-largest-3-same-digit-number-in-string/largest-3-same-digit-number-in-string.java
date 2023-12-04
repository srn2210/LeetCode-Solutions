class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1;
        int streak = 0, left = 0, right = 0;
        while(right < num.length()) {
            if(num.charAt(left) == num.charAt(right)) {
                streak++;
                right++;
                if(streak >= 3) ans = Math.max(ans, num.charAt(left)-'0');
            }
            else {
                streak = 0;
                left = right;
            }
        }
        return ans == -1 ? "" : String.valueOf(ans) + String.valueOf(ans) + String.valueOf(ans);
    }
}