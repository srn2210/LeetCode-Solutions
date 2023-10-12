/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length()-1;
        int ind = 0, val = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int num = mountainArr.get(mid);
            int numL = mid-1 >= 0 ? mountainArr.get(mid-1) : -1;
            int numR = mid+1 < mountainArr.length() ? mountainArr.get(mid+1) : -1;
            if(num > numL && num > numR) {
                ind = mid;
                val = num;
                break;
            }
            else if(num > numL) left = mid + 1;
            else right = mid - 1;
        }
        if(val < target) return -1;
        left = 0;
        right = ind;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int num = mountainArr.get(mid);
            if(num >= target) right = mid;
            else left = mid + 1;
        }
        int ans1 = left;
        if(mountainArr.get(ans1) > target) ans1 = mountainArr.length();
        left = ind;
        right = mountainArr.length()-1;
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            int num = mountainArr.get(mid);
            if(num >= target) left = mid;
            else right = mid - 1;
        }
        int ans2 = left;
        if(mountainArr.get(ans2) > target) ans2 = mountainArr.length();
        return ans1 == mountainArr.length() && ans2 == mountainArr.length() ? -1 : Math.min(ans1, ans2);
    }
}