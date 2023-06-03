class SnapshotArray {
    int snaps;
    List<List<Pair<Integer, Integer>>> arr;
    public SnapshotArray(int length) {
        arr = new ArrayList<>();
        snaps = 0;
        for(int i=0; i<length; i++) {
            var list = new ArrayList<Pair<Integer, Integer>>();
            list.add(new Pair(0,0));
            arr.add(list);
        }
    }
    
    public void set(int index, int val) {
        arr.get(index).add(new Pair(snaps, val));
    }
    
    public int snap() {
        return snaps++;
    }
    
    public int get(int index, int snap_id) {
        int left = 0, right = arr.get(index).size()-1;
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            if(arr.get(index).get(mid).getKey() <= snap_id) left = mid;
            else right = mid - 1;
        }
        return arr.get(index).get(left).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */