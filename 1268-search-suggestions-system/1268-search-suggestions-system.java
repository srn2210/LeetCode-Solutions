class Solution {
    class TrieNode {
        TrieNode[] arr;
        boolean isWord;
        TrieNode() {
            arr = new TrieNode[26];
            isWord = false;
        }
        void setEnd() {
            isWord = true;
        }
        boolean isWord() {
            return isWord;
        }
    }
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            var node = root;
            for(var ch : s.toCharArray()) {
                if(node.arr[ch-'a'] == null) node.arr[ch-'a'] = new TrieNode();
                node = node.arr[ch-'a'];
            }
            node.setEnd();
        }
        void addSuggestions(TrieNode node, StringBuilder s, List<String> ans) {
            if(ans.size() == 3 || node == null) return;
            if(node.isWord()) ans.add(s.toString());
            for(char ch='a'; ch<='z'; ch++) {
                if(node.arr[ch-'a'] != null) {
                    s.append(ch);
                    addSuggestions(node.arr[ch-'a'], s, ans);
                    s.deleteCharAt(s.length()-1);
                }
            }
        }
        List<String> suggest(String prefix) {
            var node = root;
            var ans = new ArrayList<String>();
            for(char ch : prefix.toCharArray()) {
                if(node.arr[ch-'a'] == null) return ans;
                node = node.arr[ch-'a'];
            }
            addSuggestions(node, new StringBuilder(prefix), ans);
            return ans;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        var ans = new ArrayList<List<String>>();
        for(var product : products) trie.insert(product);
        var s = new StringBuilder();
        for(char ch : searchWord.toCharArray()) {
            s.append(ch);
            ans.add(trie.suggest(s.toString()));
        }
        return ans;
    }
}