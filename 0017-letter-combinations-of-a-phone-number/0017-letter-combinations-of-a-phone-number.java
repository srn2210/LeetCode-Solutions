class Solution {
    void backtrack(List<String> ans, Map<Integer, List<Character>> map, String digits, int idx, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        else {
            List<Character> temp = map.get(Character.getNumericValue(digits.charAt(idx)));
            for(int i=0; i<temp.size(); i++) {
                sb.append(temp.get(i));
                backtrack(ans, map, digits, idx+1, sb);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        char[] ch = new char[]{'a','b','c'};
        for(int i=2; i<9; i++) {
            if(i == 7) {
                for(int j=0; j<ch.length; j++) ch[j] += 4;
                continue;
            }
            map.put(i, List.of(ch[0], ch[1], ch[2]));
            for(int j=0; j<ch.length; j++) ch[j] += 3;
        }
        map.put(7, List.of('p','q','r','s'));
        map.put(9, List.of('w','x','y','z'));
        List<String> ans = new ArrayList<>();
        backtrack(ans, map, digits, 0, new StringBuilder());
        return ans;
    }
}