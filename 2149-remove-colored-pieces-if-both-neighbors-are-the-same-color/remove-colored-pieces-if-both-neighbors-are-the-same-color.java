class Solution {
    int count(String str, char col) {
        int left = 0, right = 0, ans = 0;
        while(right < str.length()) {
            if(str.charAt(right) == col) right++;
            else {
                int c = (right - left - 2);
                ans += c < 0 ? 0 : c;
                right++;
                left = right;
            }
        }
        int c = (right - left - 2);
        ans += c < 0 ? 0 : c;
        return ans;
    }
    public boolean winnerOfGame(String colors) {
        return count(colors, 'A') > count(colors, 'B');
    }
}