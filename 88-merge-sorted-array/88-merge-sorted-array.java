class Solution {
    private void swap(int[] x, int[] y, int i, int j) {
        x[i] = x[i] ^ y[j];
        y[j] = x[i] ^ y[j];
        x[i] = x[i] ^ y[j];
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=i+j+1;
        while(j>=0) {
            k = i + j + 1;
            if(i >= 0 && j >= 0 && nums1[i] > nums2[j]) {
                swap(nums1, nums1, i, k);
                i--;
            }
            else if(i == -1 || i >= 0 && j >= 0 && nums1[i] <= nums2[j]) {
                swap(nums1, nums2, k, j);
                j--;
            }
        }
    }
}