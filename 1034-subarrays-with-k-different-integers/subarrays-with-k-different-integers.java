class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int left = 0, right = 0;
        int n = nums.length;
        long ans = 0;
        while(right < n) {
            int curr = nums[right];
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while(map.size() == k) {
                if(map.get(nums[left]) == 1) map.remove(nums[left]);
                else map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        left = 0;
        right = 0;
        map.clear();
        long res = 0;
        while(right < n) {
            int curr = nums[right];
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while(map.size() > k) {
                if(map.get(nums[left]) == 1) map.remove(nums[left]);
                else map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return (int)(res-ans);
    }
}