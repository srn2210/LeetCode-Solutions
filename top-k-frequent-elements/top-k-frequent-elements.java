class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        var pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(map.get(a), map.get(b)));
        for(int key : map.keySet()) {
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }
        var ans = new int[k];
        for(int i=0; i<k; i++) ans[i] = pq.poll();
        return ans;
    }
}