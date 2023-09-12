class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        for(char ch : s.toCharArray()) {
            counts[ch-'a']++;
        }
        Arrays.sort(counts);
        var set = new HashSet<Integer>();
        int ans = s.length();
        for(int i=0; i<26; i++) {
            int freq = counts[i];
            for(int j=freq; j>0; j--) {
                if(!set.contains(j)) {
                    set.add(j);
                    ans = ans - freq + j;
                    break;
                }
                if(j == 1) ans -= freq;
            }
        }
        return s.length() - ans;
    }
}