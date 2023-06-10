class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int mod = (int)1e9+7, n = nums.length;
        long[] arr = new long[n];
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'R') arr[i] = nums[i] + (long)d;
            else arr[i] = nums[i] - (long)d;
        }
        Arrays.sort(arr);
        long sum = 0;
        int left = 0, right = n-1;
        while(left < right) {
            sum = sum + ((right - left) * Math.abs(arr[left] - arr[right]));
            sum = sum % mod;
            left++;
            right--;
        }
        return (int)sum;
    }
}