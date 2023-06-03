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
        //arr.add(list);
    }
    
    public void set(int index, int val) {
        arr.get(index).add(new Pair(snaps, val));
    }
    
    public int snap() {
        //arr.add(new HashMap<>());
        return snaps++;
    }
    
    public int get(int index, int snap_id) {
        //System.out.println(arr);
        //System.out.println(snaps);
        int left = 0, right = arr.get(index).size()-1;
        int ans = 0;
        //System.out.println(left);
        //System.out.println(right);
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            //System.out.println(mid);
            if(arr.get(index).get(mid).getKey() <= snap_id) {
                //if(mid <= snap_id) ans = mid;
                left = mid;
            }
            else right = mid - 1;
        }
        //System.out.println(arr.get(ans));

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