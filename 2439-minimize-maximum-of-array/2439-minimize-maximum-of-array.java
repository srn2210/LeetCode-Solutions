class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        double cnt = 1;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            sum += i;
            max = Math.max(max, (int) Math.ceil(sum / cnt++));
        }
        return max;
    }
}