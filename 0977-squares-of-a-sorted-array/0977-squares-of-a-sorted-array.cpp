class Solution {
public:
    int binarySearch(vector<int>& nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        while(lo < hi) {
            int mid = lo + (hi-lo) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> res(nums.size());
        int right = binarySearch(nums, 0);
        int left = right - 1;
        int i = 0;
        while(left >= 0 || right < nums.size()) {
            if(left < 0) {
                res[i] = nums[right] * nums[right];
                i++;
                right++;
            }
            else if(right >= nums.size()) {
                res[i] = nums[left] * nums[left];
                i++;
                left--;
            }
            else if(nums[right] < -nums[left]) {
                res[i] = nums[right] * nums[right];
                i++;
                right++;
            }
            else {
                res[i] = nums[left] * nums[left];
                i++;
                left--;
            }
        }
        return res;
    }
};