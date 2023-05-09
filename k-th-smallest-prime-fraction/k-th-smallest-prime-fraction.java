class Solution {
    int[] ans;
    int check(double cand, int[] arr, int k) {
        int count = 0;
        int left = 0, right = 1;
        double t = 0.0;
        while(left < arr.length-1) {
            while(right < arr.length && arr[left] > cand * arr[right]) {
                right++;
            }
            if(right == arr.length) break;
            if((double)arr[left]/arr[right] > t) {
                t = (double)arr[left]/arr[right];
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            count += arr.length - right;
            left++;
        }
        return count;
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double lo = 0, hi = 1;
        ans = new int[2];
        while(lo < hi) {
            double mid = (lo + hi) / 2;
            int res = check(mid, arr, k);
            if(res < k) lo = mid;
            else if(res > k) hi = mid;
            else return ans;
        }
        return ans;
    }
}