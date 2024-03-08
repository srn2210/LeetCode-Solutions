class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int maxFreq = 0;
        int ans = 0;
        for(int num : nums) {
            arr[num]++;
            maxFreq = Math.max(maxFreq, arr[num]);
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == maxFreq) {
                ans += maxFreq;
            }
        }
        return ans;
    }
}