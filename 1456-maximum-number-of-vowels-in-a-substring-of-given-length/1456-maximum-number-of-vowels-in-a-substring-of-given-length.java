class Solution {
    boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int count = 0, ans = 0;
        int left = 0, right = 0;
        
        while(right < s.length()) {
            if(right - left + 1 <= k) {
                if(check(s.charAt(right))) count++;
            }
            else if(right - left + 1 > k) {
                if(check(s.charAt(right))) count++;
                if(check(s.charAt(left))) count--;
                left++;
            }
            right++;
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}