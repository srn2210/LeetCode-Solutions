class Solution {
    boolean check(int c, int[] piles, int h) {
        int ans = 0;
        for(int i : piles) {
            ans += (int) Math.ceil(i / (double) c);
        }
        return ans <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for(int i : piles) {
            max = Math.max(max, i);
            sum += i;
        }
        min = (int) Math.ceil(sum / (double)h);
        int l = min;
        int r = max;
        int ans = -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(check(mid, piles, h)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}