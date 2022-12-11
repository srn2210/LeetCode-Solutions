class Solution {
public:
    void swap(vector<int>& arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void sortColors(vector<int>& nums) {
        int left = 0;
        int mid = 0;
        int right = nums.size() - 1;
        while(mid <= right) {
            if(nums[mid] == 0) {
                swap(nums, mid++, left++);
            }
            else if(nums[mid] == 2) {
                swap(nums, mid, right--);
            }
            else {
                swap(nums, mid++, left);
            }
        }
    }
};