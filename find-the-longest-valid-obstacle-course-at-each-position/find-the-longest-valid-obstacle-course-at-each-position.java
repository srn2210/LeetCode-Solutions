class Solution {
    int binarySearch(List<Integer> arr, int height) {
        int lo = 0, hi = arr.size();
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr.get(mid) > height) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        var lis = new ArrayList<Integer>();
        for(int i=0; i<ans.length; i++) {
            int height = obstacles[i];
            int idx = binarySearch(lis, height);
            if(idx >= lis.size()) lis.add(height);
            else lis.set(idx, height);
            ans[i] = idx+1;
        }
        return ans;
    }
}