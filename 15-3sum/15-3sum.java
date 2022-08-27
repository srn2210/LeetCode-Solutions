class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        int prex = Integer.MIN_VALUE;
        int prey = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int x = nums[i];
            if(x > 0) break;
            int l = i+1;
            int r = nums.length-1;
            while(l < r) {
                int y = nums[l];
                if(x + y > 0) break;
                int sum = x + y + nums[r];
                if(sum > 0) {
                    r--;
                }
                else if(sum < 0) {
                    l++;
                }
                else {
                    list.add(List.of(x, y, nums[r]));
                    while(l+1 < nums.length && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                    r--;
                }
                prex = x;
                prey = y;
            }
            while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        }
        return new ArrayList(list);
    }
}