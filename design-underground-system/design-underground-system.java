class UndergroundSystem {
    Map<String, Map<String, Pair<Long, Integer>>> map;
    Map<Integer, Pair<String, Integer>> time;
    public UndergroundSystem() {
        map = new HashMap<>();
        time = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        time.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        var entry = time.get(id);
        int tm = t - entry.getValue();
        var start = entry.getKey();
        if(!map.containsKey(start)) map.put(start, new HashMap<>());
        var m = map.get(start);
        if(!m.containsKey(stationName)) m.put(stationName, new Pair<>((long)tm, 1));
        else {
            var s = m.get(stationName);
            m.put(stationName, new Pair<>((Long)(s.getKey()+tm), s.getValue()+1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        var s = map.get(startStation).get(endStation);
        return (double)s.getKey() / s.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */