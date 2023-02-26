class CountIntervals {
    TreeMap<Integer, Integer> map;
    int count;
    public CountIntervals() {
        map = new TreeMap<>();
        count = 0;
    }
    
    Pair<Integer, Integer> leftMerge(int left, int right) {
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
        //var t1f = map.floorEntry(left);
        //var t1c = map.ceilingEntry(left);
        //var t2f = map.floorEntry(right);
        //var t2c = map.ceilingEntry(right);
        /*if(t2f == null || (t1c == null && t1f.getValue() < left) || (t1f.getValue() < left && right < t1c.getKey())) {
            map.put(left, right);
            count += right-left+1;
        }
        else if(t1f.getValue() >= left && right <= t1f.getValue()) return;*/
        /*else if(t1f.getValue() >= left && t1f.getValue() < right && t1c.getKey() <= right && right <= t1c.getValue()) {
            count += t1c.getKey() - 1 + t1f.getValue() + 1 - 1;
            int r = t1c.getValue();
            map.remove(t1c.getKey());
            map.put(t1f.getKey(), r);
        }
        else if(t1f.getValue() >= left && t1f.getValue() < right) {
            count += right - t1f.getValue();
            map.put(t1f.getKey(), right);
        }
        else if(left < t2f.getValue()) {
            while(left < t2f.getValue()) {
                
            }
        }*/
        var p = leftMerge(left, right);
        //p = rightMerge(p.getKey(), p.getValue());
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