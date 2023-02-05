class Solution {
    class Trie {
        class Node {
            Node[] arr;
            boolean end;
            Node() {
                arr = new Node[26];
                end = false;
            }
            void setEnd() {
                end = true;
                return;
            }
            boolean isEnd() {
                return end;
            }
        }
        Node root;
        Trie() {
            root = new Node();
        }
        void insert(String s) {
            Node node = root;
            for(char ch : s.toCharArray()) {
                if(node.arr[ch-'a'] == null) node.arr[ch-'a'] = new Node();
                node = node.arr[ch-'a'];
            }
            node.setEnd();
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie dict = new Trie();
        for(String ss : wordDict) {
            dict.insert(ss);
        }
        Trie.Node node = dict.root;
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(node.arr[ch-'a'] != null) {
                node = node.arr[ch-'a'];
                if(node.isEnd()) {
                    if(i == s.length()-1) return true;
                    set.add(i);
                }
                if(i == s.length()-1 && !set.isEmpty()) {
                    node = dict.root;
                    i = set.iterator().next();
                    set.remove(set.iterator().next());
                }
                else if(i == s.length()-1) return false;
            }
            else if(!set.isEmpty()) {
                node = dict.root;
                i = set.iterator().next();
                set.remove(set.iterator().next());
            }
            else return false;
        }
        return true;
    }
}