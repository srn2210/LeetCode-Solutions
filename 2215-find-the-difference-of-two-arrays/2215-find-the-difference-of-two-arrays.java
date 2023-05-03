class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var ans = new ArrayList<List<Integer>>();
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        var set3 = new HashSet<Integer>();
        for(int i : nums1) set1.add(i);
        for(int i : nums2) {
            set3.add(i);
            if(set1.contains(i)) continue;
            set2.add(i);
        }
        for(int i : set3) {
            if(set1.contains(i)) set1.remove(i);
        }
        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));
        return ans;
    }
}