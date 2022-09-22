class Solution {
    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<temp.length; i++) {
            for(int j=temp[i].length()-1; j>=0; j--) {
                ans.append(temp[i].charAt(j));
            }
            if(i < temp.length-1) ans.append(" ");
        }
        return ans.toString();
    }
}