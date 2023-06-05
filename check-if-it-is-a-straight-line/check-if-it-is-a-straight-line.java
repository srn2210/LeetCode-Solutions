class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (a,b) -> Integer.compare(a[1], b[1]));
        int left = 0, right = 1;
        double mPrev = (coordinates[right][1] - coordinates[left][1]) / (double)(coordinates[right][0] - coordinates[left][0]);
        right++;
        left++;
        while(right < coordinates.length) {
            double m = (coordinates[right][1] - coordinates[left][1]) / (double)(coordinates[right][0] - coordinates[left][0]);
            if(m != mPrev) return false;
            mPrev = m;
            right++;
            left++;
        }
        return true;
    }
}