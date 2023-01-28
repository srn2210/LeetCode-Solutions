class SummaryRanges {
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer floor = map.floorKey(value);
        Integer ceil = map.ceilingKey(value);
        if(floor != null & ceil != null) {
            int lo = map.get(floor);
            if(lo >= value - 1 && ceil == value + 1) {
                int hi = map.get(ceil);
                map.remove(ceil);
                map.put(floor, Math.max(hi, value));
            }
            else if(lo >= value - 1) {
                map.put(floor, Math.max(lo, value));
            }
            else if(ceil == value + 1) {
                int hi = map.get(ceil);
                map.remove(ceil);
                map.put(value, Math.max(hi,value));
            }
            else {
                map.put(value, value);
            }
        }
        else if(floor != null) {
            int lo = map.get(floor);
            if(lo >= value - 1) {
                map.put(floor, Math.max(lo, value));
            }
            else {
                map.put(value, value);
            }
        }
        else if(ceil != null) {
            if(ceil == value + 1) {
                int hi = map.get(ceil);
                map.remove(ceil);
                map.put(value, Math.max(hi,value));
            }
            else {
                map.put(value, value);
            }
        }
        else {
            map.put(value, value);
        }
    }
    
    public int[][] getIntervals() {
        int[][] ans  = new int[map.size()][2];
        int i = 0;
        for(var entry : map.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i++][1] = entry.getValue();
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */