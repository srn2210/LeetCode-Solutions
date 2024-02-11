class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length, m = pattern.length;
        int[] lps = new int[m];
        int r = 1, l = 0;
        while(r < m) {
            if(pattern[l] == pattern[r]) {
                lps[r++] = ++l;
            }
            else {
                if(l != 0) l = lps[l-1];
                else r++;
            }
        }

        int ans = 0;
        int arr = 1, ptr = 0;
        while(arr < n) {
            boolean flag = false;
            switch(pattern[ptr]) {
                case 1:
                    flag = nums[arr] > nums[arr-1];
                    break;
                case 0:
                    flag = nums[arr] == nums[arr-1];
                    break;
                case -1:
                    flag = nums[arr] < nums[arr-1];
                    break;
            }
            if(flag) {
                arr++;
                ptr++;
                if(ptr == m) {
                    ans++;
                    ptr = lps[ptr-1];
                }
            }
            else {
                if(ptr != 0) ptr = lps[ptr-1];
                else arr++;
            }
        }

        return ans;
    }
}