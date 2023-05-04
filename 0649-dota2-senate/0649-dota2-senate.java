class Solution {
    public String predictPartyVictory(String senate) {
        var arr = senate.toCharArray();
        var r = new LinkedList<Integer>();
        var d = new LinkedList<Integer>();
        var rp = new LinkedList<Integer>();
        var dp = new LinkedList<Integer>();
        var lhmap = new LinkedHashMap<Integer, Character>();
        var set = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++) {
            lhmap.put(i, arr[i]);
        }
        while(!lhmap.isEmpty()) {
            r.clear();
            d.clear();
            rp.clear();
            dp.clear();
            for(var entry : lhmap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if(val == 'R') r.add(key);
                else d.add(key);
            }
            for(var entry : lhmap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if(set.contains(key)) continue;
                else {
                    switch(val) {
                        case 'R':
                            if(d.isEmpty() && dp.isEmpty()) return "Radiant";
                            while(!d.isEmpty() && d.peek() < key) dp.add(d.pollFirst());
                            if(!d.isEmpty()) set.add(d.pollFirst());
                            else set.add(dp.pollFirst());
                            break;
                        case 'D':
                            if(r.isEmpty() && rp.isEmpty()) return "Dire";
                            while(!r.isEmpty() && r.peek() < key) rp.add(r.pollFirst());
                            if(!r.isEmpty()) set.add(r.pollFirst());
                            else set.add(rp.pollFirst());
                            break;
                    }
                }
            }
            for(int i : set) {
                lhmap.remove(i);
            }
            set.clear();
        }
        return null;
    }
}