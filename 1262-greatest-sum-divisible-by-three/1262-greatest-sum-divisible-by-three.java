class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int max = (int)1e4+1;
        int r11 = max, r12 = max, r21 = max, r22 = max;
        for(int i : nums) {
            sum += i;
            if(i % 3 == 1) {
                if(i <= r11) {
                    r12 = r11;
                    r11 = i;
                }
                else if(i < r12) r12 = i;
            }
            if(i % 3 == 2) {
                if(i <= r21) {
                    r22 = r21;
                    r21 = i;
                }
                else if(i < r22) r22 = i;
            }
        }
        if(sum % 3 == 0) return sum;
        else if(sum % 3 == 1) return sum - Math.min(r11, r21+r22);
        else return sum - Math.min(r11+r12, r21);
    }
}