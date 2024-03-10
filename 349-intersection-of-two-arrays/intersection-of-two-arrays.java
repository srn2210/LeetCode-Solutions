class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        var list = new ArrayList<Integer>();
        int l = 0, r = 0;
        while(l < nums1.length && r < nums2.length) {
            if(nums1[l] == nums2[r]) {
                int curr = nums1[l];
                list.add(curr);
                while(l < nums1.length && nums1[l] == curr) l++;
                while(r < nums2.length && nums2[r] == curr) r++;
            }
            else if(nums1[l] < nums2[r]) l++;
            else r++;
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}