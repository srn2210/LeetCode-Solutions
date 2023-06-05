class Solution {
    int yDiff(int[] arr1, int[] arr2) {
        return arr1[1] - arr2[1];
    }
    int xDiff(int[] arr1, int[] arr2) {
        return arr1[0] - arr2[0];
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int dy = yDiff(coordinates[1], coordinates[0]);
        int dx = xDiff(coordinates[1], coordinates[0]);
        for(int i=2; i<coordinates.length; i++) {
            if(dy * xDiff(coordinates[i], coordinates[0]) != dx * yDiff(coordinates[i], coordinates[0])) return false;
        }
        return true;
    }
}