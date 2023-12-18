class Solution {
    public int maxProductDifference(int[] nums) {
        int high = -1, scHigh = -1;
        int low = (int)1e9, scLow = (int)1e9;
        for(int num : nums) {
            if(num < low) {
                scLow = low;
                low = num;
            }
            else if(num < scLow) {
                scLow = num;
            }
            if(num > high) {
                scHigh = high;
                high = num;
            }
            else if(num > scHigh) {
                scHigh = num;
            }
        }
        return (high * scHigh) - (low * scLow);
    }
}