class Solution {
    public long putMarbles(int[] weights, int k) {
        long[] splits = new long[weights.length-1];
        for(int i=0; i<weights.length-1; i++) {
            splits[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(splits);
        long max = 0, min = 0;
        for(int i=0; i<k-1; i++) {
            min += splits[i];
            max += splits[splits.length-i-1];
        }
        return max - min;
    }
}