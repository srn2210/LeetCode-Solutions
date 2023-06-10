class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int mod = (int)1e9+7;
        int n = nums.length;
        long[][] arr = new long[n][2];
        for(int i=0; i<n; i++) {
            int dir = 0;
            if(s.charAt(i) == 'R') dir = 1;
            else dir = -1;
            arr[i] = new long[]{nums[i], dir};
        }
        for(int i=0; i<n; i++) {
            arr[i][0] = arr[i][0] + (d * arr[i][1]);
        }
        Arrays.sort(arr, (a,b) -> Long.compare(a[0], b[0]));
        long sum = 0;
        int left = 0, right = n-1;
        while(left < right) {
            sum = sum + ((right - left) * Math.abs(arr[left][0] - arr[right][0]));
            sum = sum % mod;
            left++;
            right--;
        }
        return (int)sum;
    }
}