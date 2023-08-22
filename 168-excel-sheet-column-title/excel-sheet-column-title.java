class Solution {
    Map<Integer, Character> map;
    /*void solve(StringBuilder res, int num) {
        if(num / 26 == 0) {
            res.append(map.get(num));
            return;
        }
        else if(num / 26 > 26) solve(res, num/26);
        else {
            res.append(map.get(num/26));
            solve(res, num%26);
        }
    }*/
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        map = new HashMap<Integer, Character>();
        for(int i=1; i<=26; i++) {
            map.put(i, (char)('A'-1+i));
        }
        map.put(0, 'Z');
        //System.out.println(map);
        //solve(res, columnNumber);
        while(columnNumber != 0) {
            //int num = columnNumber / 26;
            res.append(map.get(columnNumber % 26));
            columnNumber -= columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            columnNumber /= 26;
        }
        //res.append(map.get())*/
        return res.reverse().toString();
    }
}