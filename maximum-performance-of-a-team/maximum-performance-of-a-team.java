class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)1e9+7;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        long sum = 0;
        long ans = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i][0];
            pq.add(arr[i]);
            if(pq.size() > k) sum -= pq.poll()[0];
            ans = Math.max(ans, sum * arr[i][1]);
        }
        return (int)(ans % mod);
    }
}