class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        var map = new HashMap<Integer, Set<Integer>>();
        int start = 0;
        for(int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], a -> new HashSet<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], a -> new HashSet<>()).add(pair[0]);
        }
        for(int key : map.keySet()) {
            if(map.get(key).size() == 1) start = key;
        }
        int[] arr = new int[adjacentPairs.length+1];
        for(int i=0; i<arr.length; i++) {
            arr[i] = start;
            if(i == arr.length-1) return arr;
            var it = map.get(start).iterator();
            //System.out.println(map.get(start));
            int next = it.next();
            if(next == start) next = it.next();
            map.get(start).remove(next);
            map.get(next).remove(start);
            if(map.get(start).size() == 0) map.remove(start);
            start = next;
        }
        return arr;
    }
}