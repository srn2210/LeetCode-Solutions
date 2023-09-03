class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0, right = 0, n = chargeTimes.length;
        var pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(chargeTimes[b], chargeTimes[a]));
        long sum = 0;
        int ans = 0;
        while(right < n) {
            sum += runningCosts[right];
            pq.add(right);
            long max = chargeTimes[pq.peek()];
            long cost = max + ((right - left + 1) * sum);
            while(cost > budget) {
                sum -= runningCosts[left];
                left++;
                while(!pq.isEmpty() && pq.peek() < left) pq.poll();
                max = 0;
                if(pq.size() > 0) max = chargeTimes[pq.peek()];
                cost = max + ((right - left + 1) * sum);
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}