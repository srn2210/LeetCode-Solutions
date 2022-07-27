class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int max1 = values[0];
        
        for(int i=1; i<values.length; i++){
            max = Math.max(max, max1+values[i]-i);
            max1 = Math.max(max1, values[i]+i);
        }
        
        return max;
    }
}