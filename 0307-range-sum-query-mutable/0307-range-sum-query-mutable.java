class NumArray {
    class FenwickTree {
        int[] tree;
        int length;
        FenwickTree(int[] arr) {
            length = arr.length + 1;
            tree = new int[length];
            for(int i=1; i<length; i++)
                update(i, arr[i-1]);
        }
        void update(int i, int val) {
            for(int j=i; j<length; j += j & -j) {
                tree[j] += val;
            }
        }
        int sum(int i) {
            int ans = 0;
            for(int j=i; j>0; j -= j & -j) {
                ans += tree[j];
            }
            return ans;
        }
    }
    FenwickTree tree;
    int[] og;
    public NumArray(int[] nums) {
        og = nums;
        tree = new FenwickTree(nums);
    }
    
    public void update(int index, int val) {
        tree.update(index+1, val - og[index]);
        og[index] = val;
        return;
    }
    
    public int sumRange(int left, int right) {
        return tree.sum(right+1) - tree.sum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */