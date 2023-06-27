class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var ans = new ArrayList<List<Integer>>();
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        var vis = new HashSet<Pair<Integer, Integer>>();
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        vis.add(new Pair<>(0, 0));
        while(!pq.isEmpty() && k-- > 0) {
            int i = pq.peek()[1];
            int j = pq.poll()[2];
            ans.add(List.of(nums1[i], nums2[j]));
            while(i + 1 < nums1.length && !vis.contains(new Pair<>(i+1, j))) {
                pq.add(new int[]{nums1[i+1] + nums2[j], i+1, j});
                vis.add(new Pair<>(i+1, j));
            }
            while(j + 1 < nums2.length && !vis.contains(new Pair<>(i, j+1))) {
                pq.add(new int[]{nums1[i] + nums2[j+1], i, j+1});
                vis.add(new Pair<>(i, j+1));
            }
        }
        return ans;
    }
}