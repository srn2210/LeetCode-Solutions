class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cnt = 0;
        int prev = 0;
        for(int i : arr) {
            cnt += i - prev - 1;
            prev = i;
            if(cnt >= k) break;
        }
        if(cnt < k) return prev + (k - cnt);
        return prev - (cnt - k) - 1;
    }
}