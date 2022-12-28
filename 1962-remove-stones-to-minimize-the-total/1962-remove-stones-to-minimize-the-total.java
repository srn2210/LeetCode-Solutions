class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : piles) {
            pq.add(i);
        }
        while(k-- > 0) {
            int t = pq.poll();
            pq.add(t - (int)Math.floor(t/2));
        }
        int ans = 0;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}