class RangeFreqQuery {
    
    class SegmentTree {
        Map<Integer, Integer>[] seg;
        int[] arr;
        SegmentTree(int[] arrcpy) {
            arr = new int[arrcpy.length];
            System.arraycopy(arrcpy, 0, arr, 0, arr.length);
            seg = new Map[4 * arr.length];
            for(int i=0; i<seg.length; i++) {
                seg[i] = new HashMap<>();
            }
            buildTree(0, 0, arrcpy.length-1);
        }
        void buildTree(int idx, int left, int right) {
            if(left == right) {
                seg[idx].put(arr[left], seg[idx].getOrDefault(arr[left], 0) + 1);
                return;
            }
            int mid = left + (right - left) / 2;
            buildTree(2 * idx + 1, left, mid);
            buildTree(2 * idx + 2, mid + 1, right);
            for(Map.Entry<Integer, Integer> entry : seg[2 * idx + 1].entrySet()) {
                seg[idx].put(entry.getKey(), seg[idx].getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
            for(Map.Entry<Integer, Integer> entry : seg[2 * idx + 2].entrySet()) {
                seg[idx].put(entry.getKey(), seg[idx].getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        int query(int idx, int left, int right, int l, int r, int val) {
            if(l > right || r < left) return 0;
            if(l <= left && right <= r) return seg[idx].getOrDefault(val, 0);
            int mid = left + (right - left) / 2;
            return query(2 * idx + 1, left, mid, l, r, val) + query(2 * idx + 2, mid + 1, right, l, r, val);
        }
    }

    int len;
    SegmentTree obj;
    public RangeFreqQuery(int[] arr) {
        len = arr.length-1;
        obj = new SegmentTree(arr);
        //System.out.println(Arrays.toString(obj.seg));
    }
    
    public int query(int left, int right, int value) {
        return obj.query(0, 0, len, left, right, value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */