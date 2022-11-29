class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] map = new int[1001];
        for(int num : nums1) {
            map[num] += 1;
        }
        for(int num : nums2) {
            if(map[num]-- > 0) list.add(num);
        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++) res[i] = list.get(i);
        return res;
    }
}