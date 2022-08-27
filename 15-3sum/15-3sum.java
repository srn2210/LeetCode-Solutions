class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> list = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
            int z = nums[i];
            if(z > 0) break;
            for(int j=i+1; j<nums.length; j++) {
                if(i == j) continue;
                int x = nums[j];
                int y = x + z;
                if(y > 0) break;
                y = -1 * y;
                if(map.containsKey(y) && map.get(y) > i && map.get(y) > j) {
                    list.add(List.of(x, y, z));
                }
            }
        }
        return new ArrayList(list);
    }
}