class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}