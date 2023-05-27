class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int[][] arr = new int[quality.length][2];
        for(int i=0; i<quality.length; i++) {
            arr[i] = new int[]{quality[i], wage[i]};
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        var pq = new PriorityQueue<int[]>((a,b) -> Double.compare((double)b[1]/b[0], (double)a[1]/a[0]));
        int sum = 0;
        double ans = 1000000000.0;
        for(int i=0; i<quality.length; i++) {
            sum += arr[i][0];
            pq.add(arr[i]);
            if(pq.size() > k) {
                sum -= pq.poll()[0];
            }
            if(i >= k-1) ans = Math.min(ans, sum*((double)pq.peek()[1]/pq.peek()[0]));
        }
        return ans;
    }
}