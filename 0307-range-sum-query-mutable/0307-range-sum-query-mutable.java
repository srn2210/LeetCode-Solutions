class NumArray {
    int[] arr;
    int[] bit;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        bit = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) arr[i] = nums[i];
        for(int i=1; i<= nums.length; i++) {
            update1(i, nums[i-1]);
        }
    }
    
    void update1(int i, int val) {
        while(i <= arr.length) {
            bit[i] += val;
            i += i & -i;
        }
    }
    
    int sum(int i) {
        int ans = 0;
        while(i > 0) {
            ans += bit[i];
            i -= i & -i;
        }
        return ans;
    }
    
    public void update(int index, int val) {
        update1(index+1, val - arr[index]);
        arr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return sum(right+1) - sum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */