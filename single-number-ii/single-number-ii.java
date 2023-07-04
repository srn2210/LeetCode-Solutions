class Solution {
    public int singleNumber(int[] nums) {
       var map = new HashMap<Integer, Integer>();
       for(int num : nums) {
           map.put(num, map.getOrDefault(num, 0)+1);
       }
       for(var entry : map.entrySet()) {
           if(entry.getValue() == 1) return entry.getKey();
       }
       return -1;
    }
}