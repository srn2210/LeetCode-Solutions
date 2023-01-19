class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] arr = new int[k];
        int sum = 0;
        int ans = 0;
        arr[0] = 1;
        for(int num : nums) {
            sum += num;
            arr[(sum % k + k) % k]++;
        }
        for(int i=0; i<k; i++) {
            ans += arr[i] * (arr[i] - 1) / 2;
        }
        return ans;
    }
}