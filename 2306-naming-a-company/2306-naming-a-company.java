class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for(int i=0; i<26; i++) set[i] = new HashSet<>();
        for(String s : ideas) set[s.charAt(0)-'a'].add(s.substring(1));
        long ans = 0;
        for(int i=0; i<25; i++) {
            for(int j=i+1; j<26; j++) {
                int t = 0;
                for(String s : set[i]) if(set[j].contains(s)) t++;
                ans += 2 * (set[i].size() - t) * (long)(set[j].size() - t);
            }
        }
        return ans;
    }
}