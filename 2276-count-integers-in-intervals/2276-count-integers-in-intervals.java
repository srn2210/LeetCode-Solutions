class CountIntervals {
    TreeMap<Integer, Integer> map;
    int count;
    public CountIntervals() {
        map = new TreeMap<>();
        count = 0;
    }
    
    Pair<Integer, Integer> merge(int left, int right) {
        var t = map.floorEntry(left);
        if(t != null && left <= t.getValue()) {
            left = Math.min(left, t.getKey());
            right = Math.max(right, t.getValue());
            count -= t.getValue() - t.getKey() + 1;
            map.remove(t.getKey());
        }
        t = map.ceilingEntry(left);
        while(t != null && ((t.getKey() <= right && right <= t.getValue()) || (right > t.getValue()))) {
            right = Math.max(right, t.getValue());
            map.remove(t.getKey());
            count -= t.getValue() - t.getKey() + 1;
            t = map.ceilingEntry(left);
        }
        return new Pair(left, right);
    }
    
    public void add(int left, int right) {
        var p = merge(left, right);
        map.put(p.getKey(), p.getValue());
        count += p.getValue() - p.getKey() + 1;
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */