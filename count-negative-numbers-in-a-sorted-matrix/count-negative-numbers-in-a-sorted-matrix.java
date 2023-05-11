class Solution {
    public int countNegatives(int[][] grid) {
        int lo = 0, hi = grid[0].length, mid = 0, i = 0, ans = 0;
        while(i < grid.length) {
            while(lo < hi) {
                mid = (hi + lo) / 2;
                if(grid[i][mid] < 0) hi = mid;
                else lo = mid + 1;
            }
            ans += grid[0].length - hi;
            //hi = lo;
            lo = 0;
            //System.out.println(hi);
            i++;
        }
        return ans;
    }
}