class Solution {
    void backtrack(List<String> ans, Map<Integer, List<Character>> map, String digits, int idx, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            //System.out.println(sb.toString());
            ans.add(sb.toString());
            return;
        }
        else {
            //System.out.println(map.get(Character.getNumericValue(digits.charAt(idx))));
            List<Character> temp = map.get(Character.getNumericValue(digits.charAt(idx)));
            for(int i=0; i<temp.size(); i++) {
                sb.append(temp.get(i));
                backtrack(ans, map, digits, idx+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        char ch1 = 'a';
        char ch2 = 'b';
        char ch3 = 'c';
        for(int i=2; i<9; i++) {
            if(i == 7) {
                ch1 += 4;
                ch2 += 4;
                ch3 += 4;
                continue;
            }
            map.put(i, List.of(ch1, ch2, ch3));
            ch1 += 3;
            ch2 += 3;
            ch3 += 3;
        }
        map.put(7, List.of('p','q','r','s'));
        map.put(9, List.of('w','x','y','z'));
        List<String> ans = new ArrayList<>();
        backtrack(ans, map, digits, 0, new StringBuilder());
        return ans;
    }
}