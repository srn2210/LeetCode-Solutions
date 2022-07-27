class Solution {
    public int longestPalindrome(String s) {
        int[] hm = new int[58];
        int ans = 0, max = 0;
        
        for(int i=0; i<s.length(); i++){
            hm[s.charAt(i) - 'A'] += 1;
        }
        
        for(int i: hm){
            if(i % 2 == 0){
                ans += i;
            }
            else if(i % 2 != 0){
                if(i > max){
                    if(max != 0) ans += max - 1;
                    max = i;
                }
                else {
                    ans += i - 1;
                }
            }
        }
        
        return ans+max;
    }
}