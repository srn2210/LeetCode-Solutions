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
        void insertStr(String s) {
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
            dict.insertStr(ss);
        }
        Trie.Node node = dict.root;
        Set<Integer> st = new LinkedHashSet<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(node.arr[ch-'a'] != null) {
                node = node.arr[ch-'a'];
                if(node.isEnd()) {
                    if(i == s.length()-1) return true;
                    st.add(i);
                }
                if(i == s.length()-1 && !st.isEmpty()) {
                    node = dict.root;
                    i = st.iterator().next();
                    st.remove(st.iterator().next());
                }
                else if(i == s.length()-1) return false;
            }
            else if(!st.isEmpty()) {
                node = dict.root;
                i = st.iterator().next();
                st.remove(st.iterator().next());
            }
            else return false;
        }
        return true;
    }
}