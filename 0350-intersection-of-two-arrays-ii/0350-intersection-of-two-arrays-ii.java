class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for(int num : nums1) {
            map1[num] += 1;
        }
        for(int num : nums2) {
            map2[num] += 1;
        }
        for(int i=0; i<1001; i++) {
            int cnt = Math.min(map1[i], map2[i]);
            for(int j=0; j<cnt; j++) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int c = 0;
        for(int num : list) res[c++] = num;
        return res;
    }
}