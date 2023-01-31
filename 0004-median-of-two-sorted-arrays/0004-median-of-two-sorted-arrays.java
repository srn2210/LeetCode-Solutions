class Solution {
    Pair<Integer, Integer> binarySearch(int[] nums, int num) {
        int lo = 0;
        int hi = nums.length-1;
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Arrays.binarySearch(nums, num);
        if(ans3 < 0) return new Pair(ans3, ans3);
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == num) {
                ans1 = Math.min(ans1, mid);
                hi = mid - 1;
            }
            else if(nums[mid] > num) hi = mid - 1;
            else lo = mid + 1;
        }
        lo = 0;
        hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == num) {
                ans2 = Math.max(ans2, mid);
                lo = mid + 1;
            }
            else if(nums[mid] < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return new Pair(ans1, ans2+1);
    }
    double find(int[] nums1, int[] nums2, int target) {
        int lo = 0;
        int hi = nums1.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = nums1[mid];
            var pos = binarySearch(nums2, num);
            int l = pos.getKey() < 0 ? -pos.getKey()-1 : pos.getKey();
            int h = pos.getValue() < 0 ? -pos.getValue()-1 : pos.getValue();
            var m1 = mid + l;
            var m2 = mid + h;
            //System.out.println(m1 + "  " + m2);
            if(m1 <= target && m2 >= target) return num;
            else if(m2 < target) lo = mid + 1;
            else hi = mid - 1;
        }
        lo = 0;
        hi = nums2.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = nums2[mid];
            var pos = binarySearch(nums1, num);
            int l = pos.getKey() < 0 ? -pos.getKey()-1 : pos.getKey();
            int h = pos.getValue() < 0 ? -pos.getValue()-1 : pos.getValue();
            var m1 = mid + l;
            var m2 = mid + h;
            //System.out.println("!! " + m1 + "  " + m2);
            if(m1 <= target && m2 >= target) return num;
            else if(m2 < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if(size % 2 != 0) {
            return find(nums1, nums2, size / 2);
        }
        else {
            return (find(nums1, nums2, size / 2) + find(nums1, nums2, size / 2 - 1)) / 2;
        }
    }
}