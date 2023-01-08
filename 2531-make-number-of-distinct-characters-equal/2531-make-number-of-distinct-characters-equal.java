class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(char ch : word1.toCharArray()) {
            a[ch-'a']++;
        }
        for(char ch : word2.toCharArray()) {
            b[ch-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(a[i] != 0) {
                for(int j=0; j<26; j++) {
                    if(b[j] != 0) {
                        a[i]--;
                        b[i]++;
                        b[j]--;
                        a[j]++;
                        int ans1 = 0;
                        int ans2 = 0;
                        for(int k=0; k<26; k++) {
                            if(a[k] > 0 && b[k] == 0) ans1++;
                            if(a[k] == 0 && b[k] > 0) ans2++;
                        }
                        if(ans1 == ans2) return true;
                        a[i]++;
                        b[i]--;
                        b[j]++;
                        a[j]--;
                    }
                }
            }
        }
        return false;
    }
}