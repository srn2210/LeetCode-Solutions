class Trie {
    
    class TrieNode {        
        Map<Character, TrieNode> map;
        boolean isEnd;
        TrieNode() {
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }
    
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        var node = this.root;
        for(char ch : word.toCharArray()) {
            if(node.map.containsKey(ch)) node = node.map.get(ch);
            else {
                node.map.put(ch, new TrieNode());
                node = node.map.get(ch);
            }
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        var node = this.root;
        for(char ch : word.toCharArray()) {
            if(!node.map.containsKey(ch)) return false;
            else node = node.map.get(ch);
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        var node = this.root;
        for(char ch : prefix.toCharArray()) {
            if(!node.map.containsKey(ch)) return false;
            else node = node.map.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */