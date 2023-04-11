class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var deque = new ArrayDeque<Integer>();
        for(int i=0; i<k; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            deque.add(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for(int i=k, j=1; i<nums.length; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            deque.add(i);
            ans[j++] = nums[deque.peekFirst()];
        }
        return ans;
    }
}