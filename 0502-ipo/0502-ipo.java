class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        Queue<int[]> avail = new PriorityQueue<>((a,b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        for(int i=0; i<profits.length; i++) {
            avail.add(new int[]{capital[i], profits[i]});
        }
        while(k-- > 0) {
            while(!avail.isEmpty() && avail.peek()[0] <= w) {
                pq.add(avail.poll());
            }
            if(!pq.isEmpty()) {
                w += pq.peek()[1];
                pq.poll();
            }
        }
        return w;
    }
}