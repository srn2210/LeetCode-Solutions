class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = -1;
        for(int val : left) max = Math.max(max, val);
        for(int val : right) max = Math.max(max, n-val);
        return max;
    }
}