class LRUCache {
    Map<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else {
            Integer temp = map.get(key);
            map.remove(key);
            map.put(key, temp);
            return temp;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == cap){
                map.remove(map.entrySet().iterator().next().getKey());
            }
            map.put(key, value);
        }
        else {
            map.remove(key);
            map.put(key, value);
        }
    }
}