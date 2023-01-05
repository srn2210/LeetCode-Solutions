class Solution {
    int binarySearch(int[] arr, List<int[]> list, int hi, int k) {
        int lo = 0;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[0] - list.get(mid)[0] >= k) {
                ans = Math.min(ans, arr[1] - list.get(mid)[1]);
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return ans;
    }
    public int shortestSubarray(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum < 0) sum = 0;
            if(sum >= list.get(list.size()-1)[0]) {
                list.add(new int[]{sum, i+1});
            }
            else {
                while(list.get(list.size()-1)[0] > sum) {
                    list.remove(list.size()-1);
                }
                list.add(new int[]{sum, i+1});
            }
            res = Math.min(res, binarySearch(list.get(list.size()-1), list, list.size()-2, k));
            if(res == 1) return res;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}