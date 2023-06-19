class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, prev = 0;
        for(int i=1; i<=gain.length; i++) {
            prev += gain[i-1];
            ans = Math.max(ans, prev);
        }
        return ans;
    }
}