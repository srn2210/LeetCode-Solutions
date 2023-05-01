class Solution {
    /*class TrieNode {
        TrieNode[] arr;
        boolean isWord;
        TrieNode() {
            arr = new TrieNode[26];
            isWord = false;
        }
        void setEnd() {
            this.isWord = true;
        }
        boolean isEnd() {
            return this.isWord;
        }
    }
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            var node = root;
            for(char ch : s.toCharArray()) {
                if(node.arr[ch-'a'] == null) node.arr[ch-'a'] = new TrieNode();
                node = node.arr[ch-'a'];
            }
            node.setEnd();
        }
        boolean wordExists(String s) {
            var node = root;
            for(char ch : s.toCharArray()) {
                if(node.arr[ch-'a'] == null) return false;
                node = node.arr[ch-'a'];
            }
            return node.isEnd();
        }
        TrieNode getNode() {
            var node = root;
            return node;
        }
    }
    int solve(TrieNode node, char[] given, char[] end, int idx) {
        //if(idx == end.length()) return node.isEnd() ? 0 : 1000001;
        for(int i=0; i<given.length; i++) {
            if(given[i] != end[i]) break;
            if(i == given.length-1) return 0;
        }
        int ans = 0;
    }*/
    boolean diff(String s1, String s2) {
        int ans = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) ans++;
        }
        return ans==1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*Trie obj = new Trie();
        for(var s : wordList) {
            obj.insert(s);
        }
        if(!obj.wordExists(endWord)) return 0;
        return solve(obj.getNode(), beginWord.toCharArray(), endWord.toCharArray(), 0);*/
        var map = new HashMap<String, List<String>>();
        for(int i=0; i<wordList.size(); i++) {
            for(int j=i+1; j<wordList.size(); j++) {
                if(diff(wordList.get(i), wordList.get(j))) {
                    map.computeIfAbsent(wordList.get(i), a -> new ArrayList<>()).add(wordList.get(j));
                    map.computeIfAbsent(wordList.get(j), a -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }
        //System.out.println(map);
        var queue = new LinkedList<String>();
        var vis = new HashSet<String>();
        for(int i=0; i<wordList.size(); i++) if(diff(beginWord, wordList.get(i))) {
            queue.add(wordList.get(i));
            vis.add(wordList.get(i));
        }
        //System.out.println(queue);
        int ans = 2;
        while(!queue.isEmpty()) {
            int size = queue.size();
            //System.out.println(queue);
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