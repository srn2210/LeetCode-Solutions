class Solution {
    int binarySearch(int[] arr, List<int[]> list, int hi, int k) {
        //int hi = list.size()-1;
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
    /*int binarySearch(int i, int arr, List<int[]> list, int k) {
        int lo;
        if(i == -1) lo = 0;
        else lo = i;
        int lo = i;
        int hi = list.size()-1;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(list.get(mid)[0] - arr >= k) {
                ans = Math.min(ans, list.get(mid)[1] - i - 1);
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ans;
    }*/
    public int shortestSubarray(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            /*if(sum + nums[i] >= sum) sum += nums[i];
            else sum = 0;*/
            sum += nums[i];
            if(sum < 0) sum = 0;
            if(sum >= list.get(list.size()-1)[0]) {
                list.add(new int[]{sum, i+1});
            }
            /*else {
                list.add(new int[]{list.get(list.size()-1)[0], i+1});
            }*/
            else {
                while(list.get(list.size()-1)[0] > sum) {
                    list.remove(list.size()-1);
                }
                list.add(new int[]{sum, i+1});
            }
            res = Math.min(res, binarySearch(list.get(list.size()-1), list, list.size()-2, k));
        }
        /*for(int[] i : list) {
            System.out.println(i[0] + "  " + i[1]);
        }*/
        
        /*int curr = 0;
        for(int i:nums) if(i >= k) return 1;
        res = Math.min(res, binarySearch(-1, curr, list, k));
        //System.out.println(res);
        for(int i=0; i<nums.length; i++) {
            curr += nums[i];
            if(curr < 0) curr = 0;
            res = Math.min(res, binarySearch(i, curr, list, k));
        }*/
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}