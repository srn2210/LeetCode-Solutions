class WordDictionary {
    class TrieNode {
        TrieNode[] map;
        boolean isEnd;
        TrieNode() {
            map = new TrieNode[26];
            isEnd = false;
        }
        TrieNode get(char ch) {return map[ch-'a'];}
        TrieNode get(int i) {return map[i];}
        boolean containsKey(int i) {return map[i] != null;}
        boolean containsKey(char ch) {return map[ch-'a'] != null;}
        void add(char ch) {map[ch-'a'] = new TrieNode();}
        void setEnd() {isEnd = true;}
        boolean isEnd() {return isEnd;}
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
    
    private boolean search(String word, int i, TrieNode node) {
        if(word.length() == i) {
            return node.isEnd();
        }
        if(word.charAt(i) == '.') {
            for(int idx=0; idx<26; idx++) {
                if(node.containsKey(idx) && search(word, i+1, node.get(idx))) return true;
            }
        }
        else if(node.containsKey(word.charAt(i)) && search(word, i+1, node.get(word.charAt(i)))) return true;
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