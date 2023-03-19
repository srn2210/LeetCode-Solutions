class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        TrieNode() {
            map = new HashMap<>();
            isEnd = false;
        }
        Set<Map.Entry<Character, TrieNode>> iterator() {
            return map.entrySet();
        }
        TrieNode get(char ch) {
            return map.get(ch);
        }
        boolean containsKey(char ch) {
            return map.containsKey(ch);
        }
        void add(char ch) {
            map.put(ch, new TrieNode());
        }
        void setEnd() {
            isEnd = true;
        }
        boolean isEnd() {
            return isEnd;
        }
        boolean isEmpty() {
            return map.isEmpty();
        }
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        var node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) node.add(ch);
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    boolean search(String word, int i, TrieNode node) {
        if(word.length() == i) {
            return node.isEnd();
        }
        if(word.charAt(i) == '.') {
            var itr = node.iterator();
            for(var it : itr) {
                if(search(word, i+1, it.getValue())) return true;
            }
        }
        else {
            if(node.containsKey(word.charAt(i)) && search(word, i+1, node.get(word.charAt(i)))) return true;
        }
        return false;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */