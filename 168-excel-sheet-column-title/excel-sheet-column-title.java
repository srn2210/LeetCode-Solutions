class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        for(int i=1; i<=26; i++) {
            map.put(i, (char)('A'-1+i));
        }
        map.put(0, 'Z');
        while(columnNumber != 0) {
            res.append(map.get(columnNumber % 26));
            columnNumber -= columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}