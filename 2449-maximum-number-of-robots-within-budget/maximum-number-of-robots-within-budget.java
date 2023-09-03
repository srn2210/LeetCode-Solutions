class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0, right = 0, n = chargeTimes.length;
        var pq = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        long sum = 0;
        int ans = 0;
        while(right < n) {
            sum += runningCosts[right];
            pq.put(chargeTimes[right], pq.getOrDefault(chargeTimes[right], 0) + 1);
            long max = pq.firstEntry().getKey();
            long cost = max + ((right - left + 1) * sum);
            while(cost > budget) {
                sum -= runningCosts[left];
                if(pq.get(chargeTimes[left]) > 1) pq.put(chargeTimes[left], pq.get(chargeTimes[left])-1);
                else pq.remove(chargeTimes[left]);
                max = 0;
                if(pq.size() > 0) max = pq.firstEntry().getKey();
                left++;
                cost = max + ((right - left + 1) * sum);
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}