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
        for(String s : dictionary) trie.insert(s);
    }
    
    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for(char ch : word1.toCharArray()) {
            res.append(keyToValue[ch-'a']);
        }
        return res.toString();
    }
    
    int solve(String word2, int idx, TrieNode curr) {
        if(curr == null) return 0;
        else if(idx >= word2.length()) {
            return curr.getCount();
        }
        else {
            var sub = word2.substring(idx, idx+2);
            int ans = 0;
            if(strToValue.containsKey(sub)) {
                for(char ch : strToValue.get(sub)) {
                    ans += solve(word2, idx+2, curr.get(ch-'a'));
                }
            }
            return ans;
        }
    }

    public int decrypt(String word2) {
        return solve(word2, 0, trie.get());
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */