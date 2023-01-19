class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] arr = new int[k];
        int sum = 0;
        int ans = 0;
        for(int num : nums) {
            sum += num;
            arr[(sum % k + k) % k]++;
        }
        for(int i=1; i<k; i++) {
            ans += arr[i] * (arr[i] - 1) / 2;
        }
        ans += arr[0] * (arr[0] + 1) / 2;
        return ans;
    }
}