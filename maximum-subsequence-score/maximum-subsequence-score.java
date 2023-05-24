class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        long sum = 0;
        long ans = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i][0];
            pq.add(arr[i]);
            if(i > k-1) {
                sum -= pq.poll()[0];
            }
            if(i >= k-1) ans = Math.max(ans, sum * pq.peek()[1]);
        }
        return ans;
    }
}