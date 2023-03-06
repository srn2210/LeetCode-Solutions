class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cnt = 0;
        int num = 1;
        while(cnt < k) {
            if(Arrays.binarySearch(arr, num++) < 0) cnt++;
        }
        return num-1;
    }
}