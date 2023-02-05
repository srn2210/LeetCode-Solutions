class Solution {
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    boolean check(String s) {
        if(set.contains(s.charAt(0)) && set.contains(s.charAt(s.length()-1))) return true;
        else return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pre = new int[words.length];
        int sum = 0;
        for(int i=0; i<words.length; i++) {
            if(check(words[i])) pre[i] = ++sum;
            else pre[i] = sum;
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            if(queries[i][0] == 0) ans[i] = pre[queries[i][1]];
            else ans[i] = pre[queries[i][1]] - pre[queries[i][0]-1];
        }
        return ans;
    }
}