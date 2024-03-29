class Solution {
    class UnionFind {
        int[] arr;
        UnionFind(int n) {
            arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = i;
        }
        int find(int p) {
            if(p == arr[p]) return p;
            return arr[p] = find(arr[p]);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(x == y) return;
            if(arr[x] > arr[y]) arr[x] = arr[y];
            else arr[y] = arr[x];
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind obj = new UnionFind(26);
        for(int i=0; i<s1.length(); i++) obj.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        StringBuilder res = new StringBuilder();
        for(char ch : baseStr.toCharArray()) res.append((char)(obj.find(ch-'a')+'a'));
        return res.toString();
    }
}