class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(!map.isEmpty()) {
            var list = new ArrayList<Integer>();
            var it = map.entrySet().iterator();
            while(it.hasNext()) {
                var entry = it.next();
                var key = entry.getKey();
                var value = entry.getValue();
                list.add(key);
                if(value == 1) {
                    it.remove();
                }
                else {
                    map.put(key, value-1);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}