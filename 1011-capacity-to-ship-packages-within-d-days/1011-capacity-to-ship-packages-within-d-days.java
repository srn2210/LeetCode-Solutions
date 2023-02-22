class Solution {
    boolean check(int mid, int[] weights, int days) {
        int curr = 0;
        int ans = 1;
        for(int weight : weights) {
            if(curr + weight > mid) {
                ans++;
                curr = weight;
            }
            else {
                curr += weight;
            }
        }
        return ans <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int least = Integer.MIN_VALUE;
        int most = 0;
        for(int weight : weights) {
            least = Math.max(least, weight);
            most += weight;
        }
        int ans = most;
        while(least <= most) {
            int mid = least + (most-least) / 2;
            if(check(mid, weights, days)) {
                ans = Math.min(ans, mid);
                most = mid-1;
            }
            else least = mid+1;
        }
        return ans;
    }
}