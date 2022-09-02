class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> map;
        
        boolean isEnd;
        
        TrieNode() {
            map = new HashMap();
        }
        
        boolean containsKey(char ch) {
            return map.get(ch) != null;
        }
        
        TrieNode get(char ch) {
            return map.get(ch);
        }
        
        void put(char ch, TrieNode node) {
            map.put(ch, node);
        }
        
        void setEnd() {
            isEnd = true;
        }
        
        boolean isEnd() {
            return isEnd;
        }
        
    }
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new TrieNode());
            node = node.get(word.charAt(i));
        }
        node.setEnd();        
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}