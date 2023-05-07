class FrequencyTracker {
    Map<Integer, Set<Integer>> freq;
    Map<Integer, Integer> map;
    public FrequencyTracker() {
        map = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public void add(int number) {
        int fr = map.getOrDefault(number, 0);
        if(freq.containsKey(fr) && freq.get(fr).contains(number)) freq.get(fr).remove(number);
        fr++;
        map.put(number, fr);
        freq.computeIfAbsent(fr, a -> new HashSet<Integer>()).add(number);
    }
    
    public void deleteOne(int number) {
        if(map.containsKey(number)) {
            int fr = map.get(number);
            freq.get(fr).remove(number);
            fr--;
            if(fr == 0) {
                map.remove(number);
                return;
            }
            freq.computeIfAbsent(fr, a -> new HashSet<Integer>()).add(number);
            map.put(number, fr);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return freq.containsKey(frequency) && freq.get(frequency).size() > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */