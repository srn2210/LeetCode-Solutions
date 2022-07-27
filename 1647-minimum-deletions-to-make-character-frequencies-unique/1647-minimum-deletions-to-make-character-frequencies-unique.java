class Solution {
    public int minDeletions(String s) {
        int count = 0;
        int tm[] = new int[26];
        
        for(int i=0; i<s.length(); i++){
            tm[s.charAt(i) - 'a'] += 1;
        }
        
        Arrays.sort(tm);
        int max = s.length();
        
        for(int i=25; i >= 0 && tm[i] > 0; i--){
            if(tm[i] > max){
                count += tm[i] - max;
                tm[i] = max;
            }
            max = Math.max(0, tm[i] - 1);
        }
        
        return count;
    }
}