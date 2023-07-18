class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int cap;
    LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        cap = capacity;
    }
    
    int get(int key) {
        if(cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(cache.size() == cap && !cache.containsKey(key)) {
            var it = cache.entrySet().iterator();
            int k = it.next().getKey();
            cache.remove(k);
        }
        if(cache.containsKey(key)) cache.remove(key);
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */