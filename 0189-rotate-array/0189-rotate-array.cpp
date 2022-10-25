class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        if(k == 0) return;
        int arr[k];
        memset(arr, 0, k);
        int j = 0;
        for(int i=nums.size()-k; i<nums.size(); i++) {
            arr[j++] = nums[i];
        }
        for(int i=nums.size()-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for(int i=0; i<k; i++) {
            nums[i] = arr[i];
        }
    }
};