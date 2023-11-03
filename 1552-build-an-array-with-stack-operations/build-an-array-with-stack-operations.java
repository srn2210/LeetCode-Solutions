class Solution {
    public List<String> buildArray(int[] target, int n) {
        var ans = new ArrayList<String>();
        var st = new Stack<Integer>();
        int ptr = 0;
        for(int i=1; i<=n; i++) {
            if(ptr == target.length) break;
            else if(target[ptr] == i) {
                ans.add("Push");
                st.push(i);
                ptr++;
            }
            else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}