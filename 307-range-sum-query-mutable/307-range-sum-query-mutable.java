class NumArray {
    int[] arr;
    int len;
    int[] b;
    public NumArray(int[] nums) {
        this.arr = nums;
        double d = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length/d);
        b = new int[len];
        
        for(int i=0; i<nums.length; i++) {
            b[i/len] += nums[i];
        }
    }
    
    public void update(int index, int val) {        
        int in = index/len;
        
        b[in] = b[in] - arr[index] + val;
        
        arr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int res = 0;
        
        int l = left/len;
        int r = right/len;
        
        if(l == r) {
            for(int i=left; i<=right; i++) {
                res += arr[i];
            }
        }
        else {
            for(int i=left; i<= (l+1)*len-1; i++) {
                res += arr[i];
            }
            for(int i=l+1; i<r; i++) {
                res += b[i];
            }
            for(int i=r*len; i<=right; i++) {
                res += arr[i];
            }
        }
        
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */