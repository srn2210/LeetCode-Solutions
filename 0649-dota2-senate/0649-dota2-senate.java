class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        var r = new LinkedList<Integer>();
        var d = new LinkedList<Integer>();
        for(int i=0; i<n; i++) {
            char ch = senate.charAt(i);
            if(ch == 'R') r.add(i);
            else d.add(i);
        }
        while(!r.isEmpty() && !d.isEmpty()) {
            int rPop = r.pollFirst();
            int dPop = d.pollFirst();
            if(rPop < dPop) r.add(rPop + n);
            else d.add(dPop + n);
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}