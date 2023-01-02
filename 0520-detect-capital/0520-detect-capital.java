class Solution {
    public boolean detectCapitalUse(String word) {
        boolean lower = false;
        boolean upper = false;
        for(int i=0; i<word.length(); i++) {
            if(Character.isLowerCase(word.charAt(i)) && !lower) {
                lower = !lower;
            }
            if(Character.isUpperCase(word.charAt(i)) && !upper && !(i==0)) {
                upper = !upper;
            }
            if(Character.isLowerCase(word.charAt(i)) && upper) {
                return false;
            }
            if(Character.isUpperCase(word.charAt(i)) && lower) {
                return false;
            }
        }
        return true;
    }
}