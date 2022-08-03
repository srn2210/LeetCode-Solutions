class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        if(map.size() == 0) {
            map.put(start, end);
            return true;
        }
        
        Integer prev = map.floorKey(start), next = map.ceilingKey(start);
        
        if( (prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        
        return false;
    }
}