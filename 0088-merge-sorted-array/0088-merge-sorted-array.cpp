class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.size() - 1;
        while(j >= 0) {
            if(i >=0 && nums1[i] >= nums2[j]) {
                swap(nums1[k--], nums1[i--]);
            }
            else {
                swap(nums1[k--], nums2[j--]);
            }
        }
    }
};