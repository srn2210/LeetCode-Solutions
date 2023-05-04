class Solution {
    public String predictPartyVictory(String senate) {
        int countR = 0, countD = 0;
        int popR = 0, popD = 0;
        var q = new LinkedList<Character>();
        for(char ch : senate.toCharArray()) {
            if(ch == 'R') countR++;
            else countD++;
            q.add(ch);
        }
        while(countR > 0 && countD > 0) {
            var t = q.poll();
            if(t == 'R') {
                if(popR == 0) {
                    q.add('R');
                    popD += 1;
                }
                else {
                    popR -= 1;
                    countR -= 1;
                }
            }
            else {
                if(popD == 0) {
                    q.add('D');
                    popR += 1;
                }
                else {
                    popD -= 1;
                    countD -= 1;
                }
            }
        }
        return countD == 0 ? "Radiant" : "Dire";
    }
}