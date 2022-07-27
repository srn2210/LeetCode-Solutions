class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        
        if(sb.toString().equalsIgnoreCase(sb.reverse().toString())) return true;
        
        return false;
        
    }
}