class Solution {
    void backtrack(int remOpen, int remClose, StringBuilder s, List<String> ans) {
        if(remOpen == 0 && remClose == 0) {
            ans.add(s.toString());
            return;
        }
        else {
            if(remOpen > 0) {
                s.append('(');
                backtrack(remOpen-1, remClose, s, ans);
                s.deleteCharAt(s.length()-1);
            }
            if(remClose > remOpen) {
                s.append(')');
                backtrack(remOpen, remClose-1, s, ans);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        var ans = new ArrayList<String>();
        backtrack(n, n, new StringBuilder(), ans);
        return ans;
    }
}