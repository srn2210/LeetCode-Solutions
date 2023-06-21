class Solution {
    boolean valid(int window, int[] nums, int k) {
        int count = 0;
        for(int i=0; i<window-1; i++) if(nums[i] == 1) count++;
        int left = 0, right = window-1;
        while(right < nums.length) {
            if(nums[right] == 1) count++;
            if(count + k >= window) return true;
            if(nums[left] == 1) count--;
            right++;
            left++;
        }
        return false;
    }
    public int longestOnes(int[] nums, int k) {
        /*var q = new LinkedList<Integer>();
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
        return ans;*/
        int lo = 0, hi = nums.length, ans = 0;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1;
            if(valid(mid, nums, k)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}