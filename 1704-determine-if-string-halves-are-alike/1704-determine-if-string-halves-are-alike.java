class Solution {
    boolean check(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(i < n/2 && check(s.charAt(i))) count++;
            else if(i >= n/2 && check(s.charAt(i))) count--;
        }
        return count == 0;
    }
}