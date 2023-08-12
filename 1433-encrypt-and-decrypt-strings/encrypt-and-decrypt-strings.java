class TrieNode {
    TrieNode[] nodes;
    int count;
    TrieNode() {
        nodes = new TrieNode[26];
        count = 0;
    }
    TrieNode get(int idx) {
        return nodes[idx];
    }
    boolean isNull(int idx) {
        return nodes[idx] == null;
    }
    void putNode(int idx, TrieNode node) {
        nodes[idx] = node;
    }
    void setCount() {
        count++;
    }
    int getCount() {
        return count;
    }
}
class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    void insert(String str) {
        var curr = root;
        for(char ch : str.toCharArray()) {
            int i = ch - 'a';
            if(curr.isNull(i)) curr.putNode(i, new TrieNode());
            curr = curr.get(i);
        }
        curr.setCount();
    }
    TrieNode get() {
        return root;
    }
}
class Encrypter {
    String[] keyToValue;
    Map<String, Set<Character>> strToValue;
    Trie trie;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        trie = new Trie();
        keyToValue = new String[26];
        strToValue = new HashMap<>();
        for(int i=0; i<keys.length; i++) {
            keyToValue[keys[i]-'a'] = values[i];
            strToValue.computeIfAbsent(values[i], a -> new HashSet<>()).add(keys[i]);
        }
        for(String s : dictionary) {
            String encrypted = encrypt(s);
            if(encrypted != null) trie.insert(encrypted);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for(char ch : word1.toCharArray()) {
            if(keyToValue[ch-'a'] == null) return null;
            res.append(keyToValue[ch-'a']);
        }
        return res.toString();
    }

    public int decrypt(String word2) {
        var curr = trie.get();
        for(char ch : word2.toCharArray()) {
            if(curr.isNull(ch-'a')) return 0;
            curr = curr.get(ch-'a');
        }
        return curr.getCount();
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */