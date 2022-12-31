class Solution {
    public String longestPalindrome(String s) {
        String ans = String.valueOf(s.charAt(0));
        for(int i=0; i<s.length(); i++) {
            int j = i-1;
            int k = i+1;
            StringBuilder str = new StringBuilder();
            str.append(s.charAt(i));            
            while(j >= 0 && k < s.length()) {
                if(s.charAt(j) == s.charAt(k)) {
                    str.append(s.charAt(k));
                    str.insert(0, s.charAt(j));
                    if(str.length() > ans.length()) {
                        ans = str.toString();
                    }
                    j--;
                    k++;
                }
                else break;
            }
        }
        for(int i=0; i<s.length(); i++) {
            int k = i;
            int j = i-1;
            StringBuilder str = new StringBuilder();
            while(j >= 0 && k < s.length()) {
                if(s.charAt(k) == s.charAt(j)) {
                    str.append(s.charAt(k));
                    str.insert(0, s.charAt(j));
                    if(str.length() > ans.length()) {
                        ans = str.toString();
                    }
                    j--;
                    k++;
                }
                else break;
            }
        }
        return ans;
    }
}