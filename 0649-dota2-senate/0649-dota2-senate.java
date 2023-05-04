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
            if(arr[i] == 'R') r.add(i);
            else d.add(i);
            lhmap.put(i, arr[i]);
        }
        while(!lhmap.isEmpty()) {
            for(var entry : lhmap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if(set.contains(key)) continue;
                else {
                    switch(val) {
                        case 'R':
                            if(d.isEmpty() && dp.isEmpty()) return "Radiant";
                            while(!d.isEmpty() && d.peek() < key) dp.addLast(d.pollFirst());
                            if(!d.isEmpty()) set.add(d.pollFirst());
                            else set.add(dp.pollFirst());
                            break;
                        case 'D':
                            if(r.isEmpty() && rp.isEmpty()) return "Dire";
                            while(!r.isEmpty() && r.peek() < key) rp.addLast(r.pollFirst());
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
            while(!r.isEmpty()) rp.addLast(r.pollFirst());
            while(!d.isEmpty()) dp.addLast(d.pollFirst());
            var t = r;
            r = rp;
            rp = t;
            t = d;
            d = dp;
            dp = t;
        }
        return null;
    }
}