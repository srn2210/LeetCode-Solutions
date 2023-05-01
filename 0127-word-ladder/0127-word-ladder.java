class Solution {
    boolean diff(String s1, String s2) {
        int ans = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) ans++;
            if(ans > 1) return false;
        }
        return ans==1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var map = new HashMap<String, List<String>>();
        for(int i=0; i<wordList.size(); i++) {
            for(int j=i+1; j<wordList.size(); j++) {
                if(diff(wordList.get(i), wordList.get(j))) {
                    map.computeIfAbsent(wordList.get(i), a -> new ArrayList<>()).add(wordList.get(j));
                    map.computeIfAbsent(wordList.get(j), a -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }
        var queue = new LinkedList<String>();
        var vis = new HashSet<String>();
        for(int i=0; i<wordList.size(); i++) if(diff(beginWord, wordList.get(i))) {
            queue.add(wordList.get(i));
            vis.add(wordList.get(i));
        }
        int ans = 2;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                var t = queue.poll();
                if(t.equals(endWord)) return ans;
                if(!map.containsKey(t)) continue;
                for(var s : map.get(t)) {
                    if(vis.contains(s)) continue;
                    else {
                        queue.add(s);
                        vis.add(s);
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}