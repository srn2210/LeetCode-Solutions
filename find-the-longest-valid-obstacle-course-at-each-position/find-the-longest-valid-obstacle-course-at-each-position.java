class Solution {
    int binarySearch(int[] arr, int height, int hi) {
        int lo = 0;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > height) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length], lis = new int[obstacles.length+1];
        int hi = 0;
        for(int i=0; i<ans.length; i++) {
            int height = obstacles[i];
            int idx = binarySearch(lis, height, hi);
            if(idx == hi) hi++;
            lis[idx] = height;
            ans[i] = idx+1;
        }
        return ans;
    }
}