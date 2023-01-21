class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        long sum = 0;
        long ans = Integer.MIN_VALUE;
        for(int i=0; i<k; i++) {
            sum += arr[i][0];
            pq.add(arr[i]);
        }
        ans = Math.max(ans, sum * arr[k-1][1]);
        for(int i=k; i<n; i++) {
            sum -= pq.poll()[0];
            pq.add(arr[i]);
            sum += arr[i][0];
            ans = Math.max(ans, sum * arr[i][1]);
        }
        return ans;
    }
}