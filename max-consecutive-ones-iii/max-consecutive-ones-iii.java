class Solution {
    public int longestOnes(int[] nums, int k) {
        var q = new LinkedList<Integer>();
        int left = 0, right = 0, ans = 0;
        while(right < nums.length) {
            if(nums[right] == 1) {
                ans = Math.max(ans, right-left+1);
                right++;                
            }
            else if(k > 0) {
                k--;
                q.add(right);
                ans = Math.max(ans, right-left+1);
                right++;
            }
            else if(!q.isEmpty()) {
                if(left == q.peek()) {
                    q.poll();
                    k++;
                }
                left++;
            }
            else {
                right++;
                left = right;
            }
        }
        return ans;
    }
}