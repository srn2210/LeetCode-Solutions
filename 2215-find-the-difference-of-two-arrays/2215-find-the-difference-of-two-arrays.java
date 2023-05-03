class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var ans = new ArrayList<List<Integer>>();
        boolean[] set1 = new boolean[2001];
        boolean[] set2 = new boolean[2001];
        for(int i : nums1) set1[i+1000] = true;
        for(int i : nums2) set2[i+1000] = true;
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();
        for(int i=0; i<2001; i++) {
            if(set1[i] && set2[i]) continue;
            else if(set1[i]) list1.add(i-1000);
            else if(set2[i]) list2.add(i-1000);
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}