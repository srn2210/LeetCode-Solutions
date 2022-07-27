class Solution {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int i:nums){
            temp = temp ^ i;
        }
        return temp;
    }
}