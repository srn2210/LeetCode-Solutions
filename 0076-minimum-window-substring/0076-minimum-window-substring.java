class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int[] targetArr = new int[58];
        for(char ch : t.toCharArray()) targetArr[ch-'A']++;
        int ansLeft = 0;
        int ansRight = 0;
        int rem = t.length();
        int ans = s.length() + 1;
        while(right < s.length()) {
            char ch = s.charAt(right++);
            if(targetArr[ch-'A'] > 0) rem--;
            targetArr[ch-'A']--;
            if(rem == 0) {
                while(left <= right && rem == 0) {
                    char c = s.charAt(left++);
                    if(right - left + 1 < ans) {
                        ans = right - left + 1;
                        ansLeft = left-1;
                        ansRight = right;
                    }
                    targetArr[c-'A']++;
                    if(targetArr[c-'A'] > 0) rem += 1;
                }
            }
        }
        return s.substring(ansLeft, ansRight);
    }
}