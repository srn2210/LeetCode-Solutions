class Solution {
    long sum(long k, int a) {
        return k * ( (2 * a) - k - 1) / 2;
    }
    boolean safe(int target, int n, int idx, int max) {
        long left = Math.min(target-1, idx), right = Math.min(target - 1, n - idx - 1);
        left = sum(left, target) + idx - left;
        right = sum(right, target) + n - idx - 1 - right;
        long total = left + right + target;
        return total <= max;
    }
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum - (n - 1);
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            if(safe(mid, n, index, maxSum)) {
                left = mid;
            }
            else right = mid - 1;
        }
        return left;
    }
}