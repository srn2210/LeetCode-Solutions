class Solution {
    List<String> generate(String s) {
        var ans = new ArrayList<String>();
        for(int i=0; i<s.length(); i++) {
            ans.add(s.substring(0,i) + "*" + s.substring(i+1));
        }
        return ans;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var map = new HashMap<String, List<String>>();
        for(int i=0; i<wordList.size(); i++) {
            for(var s : generate(wordList.get(i))) map.computeIfAbsent(s, a -> new ArrayList<>()).add(wordList.get(i));
        }
        var queue = new LinkedList<String>();
        var vis = new HashSet<String>();
        queue.add(beginWord);
        vis.add(beginWord);
        int ans = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                var t = queue.poll();
                if(endWord.equals(t)) return ans;
                for(var candidate : generate(t)) {
                    if(!map.containsKey(candidate)) continue;
                    for(var s : map.get(candidate)) {
                        if(vis.contains(s)) continue;
                        else {
                            queue.add(s);
                            vis.add(s);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}