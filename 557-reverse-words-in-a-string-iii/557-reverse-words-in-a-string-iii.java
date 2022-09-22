class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(s);
        ans = ans.reverse();
        s = ans.toString();
        String[] temp = s.split(" ");
        ans = new StringBuilder();
        for(int i=temp.length-1; i>=0; i--) {
            ans.append(temp[i]);
            if(i > 0) ans.append(" ");
        }
        return ans.toString();
    }
}