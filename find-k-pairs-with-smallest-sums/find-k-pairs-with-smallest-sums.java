class Solution {
    void solve2(List<List<Integer>> ans, int curr, int[] nums, int[] arr, int k) {
        var map = new HashMap<Integer, Integer>();
        for(int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(curr - nums[i])) {
                int n = map.get(curr - nums[i]);
                for(int j=0; j<n; j++) {
                    if(ans.size() == k) return;
                    ans.add(List.of(nums[i], curr-nums[i]));
                }
            }
        }
    }
    void solve(List<List<Integer>> ans, int curr, int[] nums, int[] arr) {
        int ptr = arr.length-1;
        for(int i=0; i<nums.length && ptr >= 0; i++) {
            while(ptr >= 0 && arr[ptr] + nums[i] > curr) {
                ptr--;
            }
            for(int j=0; j<=ptr; j++) {
                ans.add(List.of(nums[i], arr[j]));
            }
        }
    }
    boolean safe(int k, int[] nums, int[] arr, int curr) {
        long count = 0;
        int ptr = arr.length-1;
        for(int i=0; i<nums.length && ptr >= 0; i++) {
            while(ptr >= 0 && arr[ptr] + nums[i] > curr) {
                ptr--;
            }
            count += ptr + 1;
        }
        return count >= k;
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int max = (int)1e9;
        long left = -max, right = 2 * max + 1;
        var ans = new ArrayList<List<Integer>>();
        while(left < right) {
            int mid = (int)(left + (right - left) / 2);
            if(safe(k, nums1, nums2, mid)) right = mid;
            else left = mid + 1;
        }
        solve(ans, (int)left-1, nums1, nums2);
        solve2(ans, (int)left, nums1, nums2, k);
        return ans;
    }
}