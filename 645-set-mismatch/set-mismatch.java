class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, 2);
                ans[0] = num;
            }
            else map.put(num, 1);
        }
        for(int i=1; i<=nums.length; i++) {
            if(!map.containsKey(i)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}