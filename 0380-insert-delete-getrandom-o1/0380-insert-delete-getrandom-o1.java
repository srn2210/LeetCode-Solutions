class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int i = map.get(val);
        int j = list.size()-1;
        if(list.get(j) != val) {
            list.set(i, list.get(j));
            list.remove(j);
            map.remove(val);
            map.put(list.get(i), i);
        }
        else{
            list.remove(i);
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}