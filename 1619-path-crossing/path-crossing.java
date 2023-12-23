class Solution {
    public boolean isPathCrossing(String path) {
        var set = new HashSet<Pair<Integer, Integer>>();
        int x = 0, y = 0;
        set.add(new Pair<>(0, 0));
        for(char ch : path.toCharArray()) {
            switch(ch) {
                case 'N':
                    y++;
                    var p1 = new Pair<Integer, Integer>(x, y);
                    if(set.contains(p1)) return true;
                    set.add(p1);
                    break;
                case 'S':
                    y--;
                    var p2 = new Pair<Integer, Integer>(x, y);
                    if(set.contains(p2)) return true;
                    set.add(p2);
                    break;
                case 'E':
                    x++;
                    var p3 = new Pair<Integer, Integer>(x, y);
                    if(set.contains(p3)) return true;
                    set.add(p3);
                    break;
                case 'W':
                    x--;
                    var p4 = new Pair<Integer, Integer>(x, y);
                    if(set.contains(p4)) return true;
                    set.add(p4);
                    break;
            }
        }
        return false;
    }
}