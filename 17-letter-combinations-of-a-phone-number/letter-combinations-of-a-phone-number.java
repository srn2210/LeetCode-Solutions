class Solution {
    void backtrack(List<String> ans, String digits, int idx, Map<Character, String> map, StringBuilder curr) {
        if(idx == digits.length()) {
            ans.add(curr.toString());
            return;
        }
        else {
            var list = map.get(digits.charAt(idx));
            for(char ch : list.toCharArray()) {
                curr.append(ch);
                backtrack(ans, digits, idx+1, map, curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        var map = Map.of('2', "abc",
                         '3', "def",
                         '4', "ghi",
                         '5', "jkl",
                         '6', "mno",
                         '7', "pqrs",
                         '8', "tuv",
                         '9', "wxyz");
        backtrack(ans, digits, 0, map, new StringBuilder());
        return ans;
    }
}