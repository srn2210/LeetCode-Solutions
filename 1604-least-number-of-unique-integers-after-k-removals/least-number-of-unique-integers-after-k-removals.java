class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var map = new ArrayList<Integer>();
        var hmap = new HashMap<Integer, Integer>();
        for(int i : arr) {
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }
        for(var entry : hmap.values()) {
            map.add(entry);
        }
        Collections.sort(map);
        System.out.println(map);
        int ans = 0;
        for(int j=0; j<map.size() && k > 0; j++) {
            k -= map.get(j);
            if(k >= 0) ans++;
        }
        return map.size()-ans;
    }
}