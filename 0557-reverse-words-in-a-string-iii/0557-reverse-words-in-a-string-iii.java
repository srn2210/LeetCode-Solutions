class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                temp = temp.reverse();
                temp.append(ch);
                ans.append(temp);
                temp = new StringBuilder();
                continue;
            }
            temp.append(ch);
        }
        if(temp.length() != 0) {
            temp = temp.reverse();
            ans.append(temp);
        }
        return ans.toString();
    }
}