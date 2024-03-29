class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int max = (int)1e4+1;
        int r11 = max, r12 = max, r21 = max, r22 = max;
        for(int i : nums) {
            sum += i;
            switch(i % 3) {
                case 1:
                    if(i <= r11) {
                        r12 = r11;
                        r11 = i;
                    }
                    else if(i < r12) r12 = i;
                break;
                case 2:
                    if(i <= r21) {
                        r22 = r21;
                        r21 = i;
                    }
                    else if(i < r22) r22 = i;
                break;
            }
        }
        switch(sum % 3) {
            case 0: return sum;
            case 1: return sum - Math.min(r11, r21+r22);
            case 2: return sum - Math.min(r11+r12, r21);
        }
        return 0;
    }
}