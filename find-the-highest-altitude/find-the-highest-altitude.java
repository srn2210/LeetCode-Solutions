class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, prev = 0;
        for(int i=1; i<=gain.length; i++) {
            int curr = gain[i-1] + prev;
            prev = curr;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}