class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        var pq = new PriorityQueue<Long>(Collections.reverseOrder());
        long sum = 0;
        for(int i=0; i<heights.length-1; i++) {
            long diff = (long)heights[i+1] - heights[i];
            sum += diff <= 0 ? 0 : diff;
            if(diff > 0) pq.add(diff);
            if(sum > bricks) {
                if(ladders == 0) return i;
                else {
                    ladders--;
                    sum -= pq.poll();
                }
            }
        }
        return heights.length-1;
    }
}