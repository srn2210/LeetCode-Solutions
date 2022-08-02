class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransom = new int[26];
        int[] mag = new int[26];
        
        for(int i=0; i<ransomNote.length(); i++) {
            ransom[ransomNote.charAt(i) - 'a'] += 1;
        }
        
        for(int i=0; i<magazine.length(); i++) {
            mag[magazine.charAt(i) - 'a'] += 1;
        }
        
        for(int i=0; i<ransom.length; i++) {
            if(ransom[i] > mag[i]) return false;
        }
        
        return true;
    }
}