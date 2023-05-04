class Solution {
    class TrieNode {
        TrieNode[] arr;
        //boolean isWord;
        String word;
        TrieNode() {
            arr = new TrieNode[26];
            //isWord = false;
            word = null;
        }
        TrieNode get(char ch) {
            return arr[ch-'a'];
        }
        /*void setEnd() {
            isWord = true;
        }
        boolean isEnd() {
            return isWord;
        }*/
        void create(char ch) {
            arr[ch-'a'] = new TrieNode();
        }
    }
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            var node = root;
            for(char ch : s.toCharArray()) {
                if(node.get(ch) == null) node.create(ch);
                node = node.get(ch);
            }
            node.word = s;
        }
    }
    void explore(char[][] board, int i, int j, TrieNode node, boolean[][] vis, List<String> ans, StringBuilder s) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || node == null || vis[i][j]) return;
        vis[i][j] = true;
        //s.append(board[i][j]);
        if(node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        if(i+1 < board.length) explore(board, i+1, j, node.get(board[i+1][j]), vis, ans, s);
        if(j+1 < board[0].length) explore(board, i, j+1, node.get(board[i][j+1]), vis, ans, s);
        if(i-1 >= 0) explore(board, i-1, j, node.get(board[i-1][j]), vis, ans, s);
        if(j-1 >= 0) explore(board, i, j-1, node.get(board[i][j-1]), vis, ans, s);
        vis[i][j] = false;
        //s.deleteCharAt(s.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for(String s : words) t.insert(s);
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        var ans = new ArrayList<String>();
        var word = new StringBuilder();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(t.root.get(board[i][j]) != null) explore(board, i, j, t.root.get(board[i][j]), vis, ans, word);
            }
        }
        return ans;
    }
}