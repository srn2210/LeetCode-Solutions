class SnapshotArray {
    TreeMap[] map;
    int snaps;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        snaps = 0;
        for(int i=0; i<length; i++) {
            map[i] = new TreeMap<Integer, Integer>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snaps, val);
    }
    
    public int snap() {
        return snaps++;
    }
    
    public int get(int index, int snap_id) {
        int key = (int)map[index].floorKey(snap_id);
        return (int)map[index].get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */