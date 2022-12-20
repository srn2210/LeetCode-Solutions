class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp = map.getOrDefault(key, null);
        if(temp != null) {
            temp.put(timestamp, value);
        }
        else {
            temp = new TreeMap<>();
            temp.put(timestamp, value);
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> temp = map.getOrDefault(key, null);
        if(temp != null) {
            Integer k = temp.floorKey(timestamp);
            if(k != null) return temp.get(k);
            return "";
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */