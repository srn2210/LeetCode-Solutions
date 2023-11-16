class Solution {
    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        TrieNode() {
            arr = new TrieNode[2];
            isEnd = false;
        }
        void setEnd() {
            isEnd = true;
        }
        boolean isEnd() {
            return isEnd;
        }
        TrieNode get(int idx) {
            return arr[idx];
        }
        boolean isNull(int idx) {
            return arr[idx] == null;
        }
        void createNode(int idx) {
            arr[idx] = new TrieNode();
        }
    }
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String str) {
            TrieNode node = root;
            for(char ch : str.toCharArray()) {
                switch(ch) {
                    case '0':
                        if(node.isNull(0)) node.createNode(0);
                        node = node.get(0);
                        break;
                    default:
                        if(node.isNull(1)) node.createNode(1);
                        node = node.get(1);
                        break;
                }
            }
            node.setEnd();
        }

    }
    boolean dfs(StringBuilder s, TrieNode node) {
        if(node.isNull(0)) {
            s.append('0');
            return true;
        }
        if(node.isNull(1)) {
            s.append('1');
            return true;
        }
        if(node.isEnd()) return false;
        s.append('0');
        if(dfs(s, node.get(0))) return true;;
        s.deleteCharAt(s.length()-1);
        
        s.append('1');
        if(dfs(s, node.get(1))) return true;
        s.deleteCharAt(s.length()-1);
        
        return false;
    }
    String findAns(Trie trie, int n) {
        StringBuilder s = new StringBuilder();
        TrieNode node = trie.root;
        dfs(s, node);
        while(s.length() < n) {
            s.append('0');
        }
        return s.toString();
    }
    public String findDifferentBinaryString(String[] nums) {
        Trie trie = new Trie();
        for(String num : nums) {
            trie.insert(num);
        }
        return findAns(trie, nums[0].length());
    }
}