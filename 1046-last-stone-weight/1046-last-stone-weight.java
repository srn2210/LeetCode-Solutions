class Solution {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : stones) pq.add(i);
        while(pq.size() >= 2) {
            int y = pq.poll();
            int x = pq.poll();
            if(x == y) continue;
            else pq.add(y-x);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}