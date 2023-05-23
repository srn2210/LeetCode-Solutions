class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, a -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    String bsearch(List<Pair<Integer, String>> list, int key) {
        int lo = 0;
        int hi = list.size()-1;
        while(lo < hi) {
            int mid = (lo + (hi - lo) / 2) + 1;
            if(list.get(mid).getKey() > key) hi = mid - 1;
            else lo = mid;
        }
        if(list.get(lo).getKey() <= key) return list.get(lo).getValue();
        else return "";
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        else {
            return bsearch(map.get(key), timestamp);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */