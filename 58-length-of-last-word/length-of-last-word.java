class Solution {
    public int lengthOfLastWord(String s) {
        boolean space = false, word = false;
        StringBuilder ans = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            var ch = s.charAt(i);
            if(space && word && ch == ' ') break;
            if(!space && ch == ' ') space = true;
            if(!word && ch != ' ') {
                word = true;
                space = true;
            }
            if(ch != ' ') ans.append(ch);
        }
        return ans.length();
    }
}