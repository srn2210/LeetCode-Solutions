class Solution {
    public int[] rearrangeArray(int[] nums) {
        var pos = new ArrayDeque<Integer>();
        var neg = new ArrayDeque<Integer>();
        int ptr = 0, fwd = 0;
        while(ptr < nums.length) {
            int num = nums[ptr];
            if(ptr % 2 == 0) {
                if(!pos.isEmpty()) nums[ptr++] = pos.poll();
                else {
                    while(fwd < nums.length && nums[fwd] < 0) {
                        neg.add(nums[fwd++]);
                    }
                    nums[ptr++] = nums[fwd++];
                }
            }
            else {
                if(!neg.isEmpty()) nums[ptr++] = neg.poll();
                else {
                    while(fwd < nums.length && nums[fwd] > 0) {
                        pos.add(nums[fwd++]);
                    }
                    nums[ptr++] = nums[fwd++];
                }
            }
        }
        return nums;
    }
}