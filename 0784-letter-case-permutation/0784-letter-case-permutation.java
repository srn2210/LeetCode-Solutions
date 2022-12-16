class Solution {
    void backtrack(char[] s, List<String> res, int j) {
        res.add(String.valueOf(s));
        for(int i=j; i<s.length; i++) {
            if(Character.isAlphabetic(s[i])) {
                if(Character.isUpperCase(s[i])) {
                    s[i] = Character.toLowerCase(s[i]);
                    backtrack(s, res, i+1);
                    s[i] = Character.toUpperCase(s[i]);
                }
                else {
                    s[i] = Character.toUpperCase(s[i]);
                    backtrack(s, res, i+1);
                    s[i] = Character.toLowerCase(s[i]);
                }
            }
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), res, 0);
        return res;
    }
}