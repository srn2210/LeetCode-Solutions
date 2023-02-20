class Solution {
    public String intToRoman(int num) {
        var map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int t = 1;
        StringBuilder res = new StringBuilder();
        while(num != 0) {
            int temp = num % 10;
            temp *= t;
            if(temp == 0) {
                num /= 10;
                t *= 10;
                continue;
            }
            if(!map.containsKey(temp)) {
                while(!map.containsKey(temp)) {
                    temp -= t;
                    res.insert(0, map.get(t));
                }
                res.insert(0, map.get(temp));
                num /= 10;
                t *= 10;
                continue;
            }
            res.insert(0, map.get(temp));
            num /= 10;
            t *= 10;
        }
        return res.toString();
    }
}