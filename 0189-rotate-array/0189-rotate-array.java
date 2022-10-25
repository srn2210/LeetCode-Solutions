class Solution {
    public void rotate(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        for(int i:nums) {
            dq.offer(i);
        }
        while(k-- > 0) {
            dq.offerFirst(dq.pollLast());
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = dq.poll();
        }
    }
}