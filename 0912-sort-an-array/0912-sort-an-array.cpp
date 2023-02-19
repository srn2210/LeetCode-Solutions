class Solution {
public:
    void merge(vector<int>& nums, vector<int>& aux, int left, int mid, int right) {
        for(int i=left; i<=right; i++) aux[i] = nums[i];
        int i = left;
        int l = left;
        int r = mid;
        left = mid+1;
        while(l <= r && left <= right) {
            if(aux[l] < aux[left]) {
                nums[i++] = aux[l++];
            }
            else {
                nums[i++] = aux[left++];
            }
        }
        if(l <= r) {
            while(l <= r) nums[i++] = aux[l++];
        }
        if(left <= right) {
            while(left <= right) nums[i++] = aux[left++];
        }
    }
    void sort(vector<int>& nums, vector<int>& aux, int left, int right) {
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        sort(nums, aux, left, mid);
        sort(nums, aux, mid+1, right);
        merge(nums, aux, left, mid, right);
    }
    vector<int> sortArray(vector<int>& nums) {
        vector<int> aux(nums.size(), 0);
        sort(nums, aux, 0, nums.size()-1);
        return nums;
    }
};