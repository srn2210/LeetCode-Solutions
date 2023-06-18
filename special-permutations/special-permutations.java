class Solution {
    int mod = (int)1e9+7;
    int ans;
    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    void solve(int[] nums, int end) {
        if(end == 0) {
            for(int i=0; i<nums.length-1; i++) {
                var flag = (nums[i] % nums[i+1] == 0) || (nums[i+1] % nums[i] == 0);
                if(!flag) return;
            }
            ans += 1;
            ans %= mod;
            return;
        }
        else {
            for(int i=0; i<=end; i++) {
                if(end + 1 < nums.length && (nums[i] % nums[end+1] == 0 || nums[end+1] % nums[i] == 0)) {
                    swap(nums, i, end);
                    solve(nums, end-1);
                    swap(nums, i, end);
                }
                else if(end == nums.length-1) {
                    swap(nums, i, end);
                    solve(nums, end-1);
                    swap(nums, i, end);
                }
            }
        }
    }
    public boolean checkAll(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]%nums[j]!=0 && nums[j]%nums[i]!=0) return false;
            }
        }
        return true;
    }
    public long factorial(int n){
        if(n==1 || n==0) return 1;
        else return n*factorial(n-1);
    }
    public int specialPerm(int[] nums) {
        if(checkAll(nums)) return (int)(factorial(nums.length)%1000000007L);
        ans = 0;
        solve(nums, nums.length-1);
        return ans % mod;
    }
}