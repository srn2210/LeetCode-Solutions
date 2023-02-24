class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        var pq = new PriorityQueue<Long>(n, Collections.reverseOrder());
        long[] arr = new long[n];
        long min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            arr[i] = nums[i] % 2 == 0 ? nums[i] : (long)nums[i] * 2;
            min = Math.min(min, arr[i]);
            pq.add(arr[i]);
        }
        long ans = Integer.MAX_VALUE;
        while(pq.peek() % 2 == 0) {
            ans = Math.min(ans, pq.peek() - min);
            min = Math.min(min, pq.peek()/2);
            pq.add(pq.poll() / 2);
        }
        return Math.min((int)ans, (int)(pq.peek()-min));
    }
}