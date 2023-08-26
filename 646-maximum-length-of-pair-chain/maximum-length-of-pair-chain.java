class Solution {
    public int findLongestChain(int[][] pairs) {
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        for(int[] pair : pairs) pq.add(pair);
        int prev = -1001;
        int ans = 0;
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            if(prev < t[0]) {
                prev = t[1];
                ans++;
            }
        }
        return ans;
    }
}