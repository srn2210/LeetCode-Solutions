class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var dq = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0; i<k; i++) {
            //if(!dq.isEmpty() && nums[i] < nums[dq.peekLast()]) continue;
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
        }
        ans[0] = nums[dq.peekFirst()];
        for(int i=k; i<nums.length; i++) {
            while(!dq.isEmpty() && (i-dq.peekFirst()) >= k) dq.pollFirst();
            /*if(!dq.isEmpty() && nums[i] < nums[dq.peekLast()]) {
                ans[i-k+1] = nums[dq.peekFirst()];
                continue;
            }*/
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
            ans[i-k+1] = nums[dq.peekFirst()];
            //System.out.println(ans[i-k+1] + " --- " + dq);
        }
        return ans;
    }
}