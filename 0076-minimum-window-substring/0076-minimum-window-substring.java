class Solution {
    boolean check(int[] arr, int[] target) {
        for(int i=0; i<arr.length; i++) if(target[i] != 0 && arr[i] < target[i]) return false;
        return true;
    }
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int[] targetArr = new int[58];
        for(char ch : t.toCharArray()) targetArr[ch-'A']++;
        int[] sArr = new int[58];
        int ansLeft = 0;
        int ansRight = 0;
        int ans = s.length() + 1;
        while(right < s.length()) {
            char ch = s.charAt(right++);
            sArr[ch-'A']++;
            if(check(sArr, targetArr)) {
                while(left <= right && check(sArr, targetArr)) {
                    if(right - left < ans) {
                        ans = right - left + 1;
                        ansLeft = left;
                        ansRight = right;
                    }
                    sArr[s.charAt(left++)-'A']--;
                }
            }
        }
        return s.substring(ansLeft, ansRight);
    }
}