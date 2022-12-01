class Solution {
    boolean check(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring(s.length()/2, s.length());
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            if(check(s1.charAt(i))) count++;
            if(check(s2.charAt(i))) count--;
        }
        return count == 0;
    }
}