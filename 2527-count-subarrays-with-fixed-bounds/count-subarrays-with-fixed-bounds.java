class Solution {
    long solve(int[] nums, int minK, int maxK, int left, int right) {
        if(left > right) return 0;
        var qMin = new LinkedList<Integer>();
        var qMax = new LinkedList<Integer>();
        for(int i=left; i<right; i++) {
            if(nums[i] == minK) qMin.add(i);
            if(nums[i] == maxK) qMax.add(i);
        }
        long ans = 0;
        for(int i=left; i<right; i++) {
            while(!qMin.isEmpty() && qMin.peek() < i) qMin.poll();
            while(!qMax.isEmpty() && qMax.peek() < i) qMax.poll();
            if(qMin.isEmpty() || qMax.isEmpty()) break;
            ans += right - Math.max(qMin.peek(), qMax.peek());
        }
        return ans;
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int prev = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                ans += solve(nums, minK, maxK, prev, i);
                prev = i+1;
            }
        }
        ans += solve(nums, minK, maxK, prev, nums.length);
        return ans;
    }
}