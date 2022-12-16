class NumArray {
    class SegmentTree {
        int[] seg;
        int length;
        SegmentTree(int[] arr) {
            length = 4 * arr.length;
            seg = new int[length];
            buildTree(arr, 0, 0, arr.length-1);
        }
        void buildTree(int[] arr, int i, int lo, int hi) {
            if(lo == hi) {
                seg[i] = arr[lo];
                return;
            }
            int mid = (hi + lo) / 2;
            buildTree(arr, (2 * i) + 1, lo, mid);
            buildTree(arr, (2 * i) + 2, mid + 1, hi);
            seg[i] = seg[(2 * i) + 1] + seg[(2 * i) + 2];
        }
        int sum(int l, int r, int i, int segl, int segr) {
            if(l > segr || r < segl) return 0;
            if(l <= segl && r >= segr) return seg[i];
            int mid = (segl + segr) / 2;
            int left = sum(l, r, (2 * i) + 1, segl, mid);
            int right = sum(l, r, (2 * i) + 2, mid + 1, segr);
            return left + right;
        }
        int update(int l, int r, int i, int segl, int segr, int val) {
            if(l > segr || r < segl) return seg[i];
            if(segl == segr && segl == l) return seg[i] = val;
            int mid = (segl + segr) / 2;
            int left = update(l, r, (2 * i) + 1, segl, mid, val);
            int right = update(l, r, (2 * i) + 2, mid + 1, segr, val);
            return seg[i] = left + right;
        }
    }
    SegmentTree tree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        tree.update(index, index, 0, 0, n-1, val);
        return;
    }
    
    public int sumRange(int left, int right) {
        return tree.sum(left, right, 0, 0, n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */