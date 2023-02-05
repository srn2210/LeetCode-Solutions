class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int i : gifts) {
            pq.offer(i);
            ans += i;
        }
        while(k-- > 0) {
            var t = pq.poll();
            var temp = (int)Math.sqrt(t);
            ans -= t - temp;
            pq.offer(temp);
        }
        return ans;
    }
}