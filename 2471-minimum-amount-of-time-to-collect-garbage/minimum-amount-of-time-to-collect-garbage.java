class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int g = 0, p = 0, m = 0;
        int tg = 0, tp = 0, tm = 0;
        for(int i=0; i<garbage.length; i++) {
            for(char ch : garbage[i].toCharArray()) {
                if(ch == 'M') {
                    m += tm;
                    m++;
                    tm = 0;
                }
                else if(ch == 'G') {
                    g += tg;
                    g++;
                    tg = 0;
                }
                else {
                    p += tp;
                    p++;
                    tp = 0;
                }
            }
            if(i == travel.length) break;
            tg += travel[i];
            tm += travel[i];
            tp += travel[i];
        }
        return g + p + m;
    }
}