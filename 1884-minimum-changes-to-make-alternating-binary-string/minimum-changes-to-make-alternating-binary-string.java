class Solution {
    public int minOperations(String s) {
        int prev1 = 0, prev2 = 1;
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<s.length(); i++) {
            int curr = s.charAt(i) - '0';
            if(prev1 != curr) {
                ans1++;
            }
            if(prev2 != curr) {
                ans2++;
            }
            prev1 = prev1 ^ 1;
            prev2 = prev2 ^ 1;
        }
        return Math.min(ans1, ans2);
    }
}