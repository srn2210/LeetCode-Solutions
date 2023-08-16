class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var dq = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
        }
        ans[0] = nums[dq.peekFirst()];
        for(int i=k; i<nums.length; i++) {
            while(!dq.isEmpty() && (i-dq.peekFirst()) >= k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
            ans[i-k+1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}