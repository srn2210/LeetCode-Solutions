class Solution {
    public int arraySign(int[] nums) {
        int negCount = 0;
        boolean zero = false;
        for(int i : nums) {
            if(i == 0) zero = true;
            else if(i < 0) negCount++;
        }
        return zero ? 0 : negCount % 2 == 0 ? 1 : -1;
    }
}