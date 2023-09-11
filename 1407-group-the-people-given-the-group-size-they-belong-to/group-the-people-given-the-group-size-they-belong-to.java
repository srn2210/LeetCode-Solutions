class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        var map = new HashMap<Integer, List<List<Integer>>>();
        for(int i=0; i<groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            var list = map.get(size);
            if(list.size() == 0) {
                var t = new ArrayList<Integer>();
                t.add(i);
                map.get(size).add(t);
            }
            else if(list.get(list.size()-1).size() < size) list.get(list.size()-1).add(i);
            else {
                var t = new ArrayList<Integer>();
                t.add(i);
                map.get(size).add(t);
            }
            
        }
        var ans = new ArrayList<List<Integer>>();
        for(var it : map.values()) {
            for(var l : it) {
                ans.add(l);
            }
        }
        return ans;
    }
}