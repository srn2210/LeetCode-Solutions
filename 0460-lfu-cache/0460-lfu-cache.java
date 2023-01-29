class LFUCache {
    TreeMap<Integer, Set<Integer>> tmap;
    Map<Integer, Integer> hmap;
    Map<Integer, Integer> vmap;
    int cap;
    public LFUCache(int capacity) {
        tmap = new TreeMap<>();
        hmap = new HashMap<>();
        vmap = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        else if(vmap.containsKey(key)) {
            int k = hmap.get(key);
            tmap.get(k).remove(key);
            if(tmap.get(k).size() == 0) tmap.remove(k);
            hmap.put(key, k+1);
            tmap.computeIfAbsent(k+1, a -> new LinkedHashSet<>()).add(key);
            return vmap.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        if(hmap.containsKey(key)) {
            vmap.put(key, value);
            int k = hmap.get(key);
            tmap.get(k).remove(key);
            if(tmap.get(k).size() == 0) tmap.remove(k);
            hmap.put(key, k+1);
            tmap.computeIfAbsent(k+1, a -> new LinkedHashSet<>()).add(key);
        }
        else if(hmap.size() < cap) {
            vmap.put(key, value);
            hmap.put(key, 1);
            tmap.computeIfAbsent(1, a -> new LinkedHashSet<>()).add(key);
        }
        else {
            int k = tmap.ceilingKey(-1);
            int v = tmap.get(k).iterator().next();
            tmap.get(k).remove(v);
            if(tmap.get(k).size() == 0) tmap.remove(k);
            hmap.remove(v);
            vmap.remove(v);
            vmap.put(key, value);
            hmap.put(key, 1);
            tmap.computeIfAbsent(1, a -> new LinkedHashSet<>()).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */